package com.kdn;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kdn.model.biz.BoardService;
import com.kdn.model.biz.MemberService;
import com.kdn.model.domain.Board;

public class DITest_property {
	public static void main(String[] args) {

		BeanFactory container = new ClassPathXmlApplicationContext("com/kdn/config/beans_property.xml");
		System.out.println("Container 구동....");
		
		BoardService boardService = container.getBean(BoardService.class);
		System.out.println(boardService.search(1));
		
		MemberService memberService = container.getBean(MemberService.class);
		System.out.println(memberService.search("kdn"));
	}
}
