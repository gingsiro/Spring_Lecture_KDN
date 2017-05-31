package com.kdn;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kdn.model.domain.Board;

public class DITest4 {
	public static void main(String[] args) {
		BeanFactory container = new ClassPathXmlApplicationContext("com/kdn/config/beans4.xml");
		
		Board board = container.getBean("board", Board.class);
		System.out.println(board);
	}
}
