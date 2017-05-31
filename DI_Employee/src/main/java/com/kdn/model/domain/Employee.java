package com.kdn.model.domain;

public class Employee {
	private String 	empno	;
	private String 	ename	;
	private int 	salary	;
	private String 	position;
	private String 	address	;
	
	public Employee(String empno, String ename, int salary, String position, String address) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
		this.position = position;
		this.address = address;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(100);
		builder.append("Employee [empno=").append(empno).append(", ename=").append(ename).append(", salary=")
				.append(salary).append(", position=").append(position).append(", address=").append(address).append("]");
		return builder.toString();
	}
	
}
