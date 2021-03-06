package com.kdn;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kdn.model.biz.BoardService;
import com.kdn.model.biz.MemberService;

public class DITest_constructor {
	public static void main(String[] args) {

		BeanFactory container = new ClassPathXmlApplicationContext("com/kdn/config/beans_constructor.xml");
		System.out.println("Container 구동....");
		
		BoardService boardService = container.getBean(BoardService.class);
		System.out.println(boardService.search(1));
		
		MemberService memberService = container.getBean(MemberService.class);
		System.out.println(memberService.search("kdn"));
	}
}
