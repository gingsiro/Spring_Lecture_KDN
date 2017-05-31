package com.kdn;

import com.kdn.model.domain.Employee;
import com.kdn.model.domain.PageBean;
import com.kdn.model.service.EmployeeService;
import com.kdn.model.service.EmployeeServiceImpl;

public class EmployeeTest {
	public static void main(String[] args) {
		EmployeeService service = new EmployeeServiceImpl();
		
		System.out.println("=================등록=================");
		try {
			service.add(new Employee("1111", "홍길동", 3000000, "대리", "나주"));
			service.add(new Employee("2222", "길동홍", 3500000, "과장", "서울"));
			service.add(new Employee("3333", "홍길순", 2500000, "사원", "나주"));
			service.add(new Employee("1111", "홍길동", 3000000, "대리", "나주"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(service.searchAll(new PageBean("all", null, 1)));
		System.out.println("=================수정=================");
		try {
			service.update(new Employee("1111", "홍길동1", 3000000, "대리", "나주"));
			service.update(new Employee("2222", "길동홍1", 3500000, "과장", "서울"));
			service.update(new Employee("3333", "홍길순1", 2500000, "사원", "나주"));
			service.update(new Employee("4444", "홍길동1", 3000000, "대리", "나주"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("=================검색=================");
		try {
			System.out.println(service.search("1111"));
			System.out.println(service.search("4444"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(service.searchAll(new PageBean("address", "나주", 1)));
		System.out.println(service.searchAll(new PageBean("position", "과장", 1)));
		System.out.println("=================삭제=================");
		try {
			service.remove("1111");
			service.remove("2222");
			service.remove("3333");
			service.remove("4444");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(service.searchAll(new PageBean("all", "나주", 1)));
	}
}
