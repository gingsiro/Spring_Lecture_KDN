package com.kdn.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kdn.model.domain.Employee;
import com.kdn.model.domain.PageBean;
import com.kdn.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	
	public void add(Connection con, Employee emp) throws SQLException{
		PreparedStatement stmt = null;
		try {
			String sql = " insert into employee(empno, ename, salary, position, address) "
					   + " values(?, ?, ?, ?, ?) ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, emp.getEmpno());
			stmt.setString(2, emp.getEname());
			stmt.setInt(3, emp.getSalary());
			stmt.setString(4, emp.getPosition());
			stmt.setString(5, emp.getAddress());
			
			stmt.executeUpdate();
			
		} finally {
			DBUtil.close(stmt);
		}
	}

	
	public void update(Connection con, Employee emp) throws SQLException{
		PreparedStatement stmt = null;
		try {
			String sql = " update employee set empno=?, ename=?, salary=?, position=?, address=? "
					   + " where empno=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, emp.getEmpno());
			stmt.setString(2, emp.getEname());
			stmt.setInt(3, emp.getSalary());
			stmt.setString(4, emp.getPosition());
			stmt.setString(5, emp.getAddress());
			stmt.setString(6, emp.getEmpno());
			
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}

	
	public void remove(Connection con, String empno) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " delete from employee where empno=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, empno);

			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}

	
	public Employee search(Connection con, String empno) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = " select * from employee where empno = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, empno);
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				return new Employee( rs.getString("empno")
						           , rs.getString("ename")
						           , rs.getInt("salary")
						           , rs.getString("position")
						           , rs.getString("address")
						           );
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return null;
	}

	
	public List<Employee> searchAll(Connection con, PageBean bean) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			String key = bean.getKey();
			String word = bean.getWord();
			int idx = 1;
			
			StringBuilder sql = new StringBuilder(200);
			sql.append(" select a.*                        \n");
			sql.append(" from ( select rownum ro, b.*      \n");
			sql.append(" 	   from ( select *             \n");
			sql.append(" 	   		  from employee        \n");
			sql.append(" 	   		  where 1=1            \n");
			
			// 검색 조건에 따른 다른 쿼리 작성 (동적 쿼리)
			// 검색 조건이 있고 검색할 단어가 있다면
			if(key != null && !key.equals("all") && word != null && word.trim().equals("")){
				if (key.equals("ename")) {
					sql.append(" 	and	ename=?			   \n");
				}else if(key.equals("position")) {
					sql.append(" 	and	position=?		   \n");
				}else if(key.equals("address")) {
					sql.append(" 	and	address like '%'||?||'%'	\n");
				}
			}
			sql.append(" 	   		  order by salary desc \n");
			sql.append(" 	   		  ) b                  \n");
			sql.append(" 	 ) a                           \n");
			sql.append(" where ro between ? and ?          \n");

			// sql 에 StringBuilder를 사용했기 때문에 toString을 작성해줘야함
			stmt = con.prepareStatement(sql.toString());
			
			if(key != null && !key.equals("all") && word != null && word.trim().equals("")){
				stmt.setString(idx++, word);				
			}
			stmt.setInt(idx++, bean.getStart());
			stmt.setInt(idx++, bean.getEnd());
			rs = stmt.executeQuery();
			
			//중간삽입 삭제 적을땐 ArrayList, 중간삽입 삭제 많을땐 LinkedList
			ArrayList<Employee> employees = new ArrayList<Employee>(bean.getInterval());
			while(rs.next()){
				employees.add(new Employee( rs.getString("empno")
				           				  , rs.getString("ename")
				           				  , rs.getInt("salary")
				           				  , rs.getString("position")
				           				  , rs.getString("address")
										  ));
			}
			return employees;
			
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
	}

	
	public int getCount(Connection con, PageBean bean) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String key = bean.getKey();
			String word = bean.getWord();
			StringBuilder sql = new StringBuilder(100);
			
			sql.append(" select count(*) cnt from employee where 1=1 ");
			if(key != null && !key.equals("all") && word != null && word.trim().equals("")){
				if (key.equals("ename")) {
					sql.append(" 	and	ename=?			   \n");
				}else if(key.equals("position")) {
					sql.append(" 	and	position=?		   \n");
				}else if(key.equals("address")) {
					sql.append(" 	and	address like '%'||?||'%'	\n");
				}
			}
			
			stmt = con.prepareStatement(sql.toString());
			if(key != null && !key.equals("all") && word != null && word.trim().equals("")){
				stmt.setString(1, word);				
			}
			
			rs = stmt.executeQuery();
			if(rs.next()){
				return rs.getInt("cnt");
			}
			
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
		return 0;
	}

}
