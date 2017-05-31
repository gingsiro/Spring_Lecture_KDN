package com.kdn.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kdn.model.dao.EmployeeDao;
import com.kdn.model.dao.EmployeeDaoImpl;
import com.kdn.model.domain.Employee;
import com.kdn.model.domain.EmployeeException;
import com.kdn.model.domain.PageBean;
import com.kdn.util.DBUtil;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao dao = new EmployeeDaoImpl();
	
	@Override
	public void add(Employee emp) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String empno = emp.getEmpno();
			Employee find = dao.search(con, empno);
			if (find != null) {
				String msg = String.format("사원번호 %s번은 이미 등록되어 있어", empno);
				throw new EmployeeException(msg);
			}
			dao.add(con, emp);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException("사원 정보 등록 중 오류 발생");
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public void update(Employee emp) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String empno = emp.getEmpno();
			Employee find = dao.search(con, empno);
			if (find == null) {
				String msg = String.format("사원번호 %s번은 등록 안돼있는데?", empno);
				throw new EmployeeException(msg);
			}
			dao.update(con, emp);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException("사원 정보 수정 중 오류 발생");
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public void remove(String empno) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Employee find = dao.search(con, empno);
			if (find == null) {
				String msg = String.format("사원번호 %s번은 등록 안돼있는데?", empno);
				throw new EmployeeException(msg);
			}
			dao.remove(con, empno);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException("사원 정보 삭제 중 오류 발생");
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public Employee search(String empno) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Employee find = dao.search(con, empno);
			if (find == null) {
				String msg = String.format("사원번호 %s번은 등록 안돼있는데?", empno);
				throw new EmployeeException(msg);
			}
			return find;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException("사원 정보 검색 중 오류 발생");
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public List<Employee> searchAll(PageBean bean) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			//int total = dao.getCount(con, bean);
			return dao.searchAll(con, bean);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException("사원 정보 검색 중 오류 발생");
		} finally {
			DBUtil.close(con);
		}
	}

}
