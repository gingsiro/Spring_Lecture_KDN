package com.kdn;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kdn.model.domain.Board;

public class DITest3 {
	public static void main(String[] args) {
		BeanFactory container = new ClassPathXmlApplicationContext("com/kdn/config/beans3.xml");
		Board board = container.getBean("board", Board.class);
		System.out.println(board);
		Board board2 = container.getBean("board2", Board.class);
		System.out.println(board2);
		//결과를 보면 기본 생성자가 호출이 되고 
		//setter 메서드로 주입하게 된다.
	}
}
