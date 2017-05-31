package com.kdn.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimeCalc {
	public Object time(ProceedingJoinPoint jp){
		double start = System.currentTimeMillis();
		try {
			return jp.proceed(); //핵심모듈 수행
		} catch (Throwable e) {
		} finally{
			double end = System.currentTimeMillis();
			System.out.println("===================수행 시간 계산===================");
			System.out.println("메서드 이름 : " + jp.getSignature());
			System.out.print("수행 시간 : ");
			System.out.print(end - start);
			System.out.println("ms");
		}
		
		return new Object();
	}
}
