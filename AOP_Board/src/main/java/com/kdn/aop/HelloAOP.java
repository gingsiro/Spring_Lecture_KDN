package com.kdn.aop;

import org.aspectj.lang.JoinPoint;

public class HelloAOP {
	public void hello(JoinPoint jp){
		System.out.println("===================hello AOP===================");
		System.out.println("메서드 이름 : " + jp.getSignature());
		Object[] args = jp.getArgs();
		
		if(args != null){
			System.out.println("인자 정보");
			for (Object arg : args) {
				System.out.println(arg);
			}
		}
	}
}
