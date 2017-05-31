package com.kdn;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kdn.model.domain.Board;

public class DITest1 {
	public static void main(String[] args) {
		/*
		 * Spring Container 객체 생성
		 * 	- 생성자에 bean configuration 파일을 인자로 전달하면
		 * 	  Spring Container는 xml을 파싱하여 xml내에 설정된
		 * 	  모든 객체를 생성한다.
		 * 	- 종류
		 * 	  BeanFactory
		 * 	  ApplicationContext
		 * 	  WebApplicationContext		
		 */
		BeanFactory container = new ClassPathXmlApplicationContext("com/kdn/config/beans1.xml");
		System.out.println("Container 구동....");
		
//		Container에서 객체 추출
		/*
		 * getBean(String id) : id에 해당하는 객체를 Object로 리턴
		 * getBean(Class cls) : 
		 * 	- Class 타입에 해당하는 객체를 해당 타입으로 리턴
		 * 	- 지정된 타입으로 여러개의 객체가 Container에 등록되어 있으면 Exception 발생
		 * getBean(String id, Class cls) : 
		 * 	- id에 해당하는 객체를 해당 타입으로 리턴
		 */
		
//		Board board = (Board)container.getBean("board");
		Board board = container.getBean("board", Board.class);
		Board board2 = container.getBean("board", Board.class);
		
		System.out.println(board.hashCode());
		System.out.println(board2.hashCode());
	}
}
