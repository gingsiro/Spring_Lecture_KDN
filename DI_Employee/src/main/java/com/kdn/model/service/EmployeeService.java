package com.kdn.model.service;

import java.util.List;

import com.kdn.model.domain.Employee;
import com.kdn.model.domain.PageBean;

public interface EmployeeService {
	public void add(Employee emp);
	public void update(Employee emp);
	public void remove(String empno);
	public Employee search(String empno);
	public List<Employee> searchAll(PageBean bean);
}
