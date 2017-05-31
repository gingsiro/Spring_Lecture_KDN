package com.kdn.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kdn.model.domain.Employee;
import com.kdn.model.domain.PageBean;

public interface EmployeeDao {
	public void add(Connection con, Employee emp) throws SQLException;
	public void update(Connection con, Employee emp) throws SQLException;
	public void remove(Connection con, String empno) throws SQLException;
	public Employee search(Connection con, String empno) throws SQLException;
	public List<Employee> searchAll(Connection con, PageBean bean) throws SQLException;
	public int getCount(Connection con, PageBean bean) throws SQLException;
}
