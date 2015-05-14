package com.jshop.action.aspect.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class BaseAppAspect {
	
	/**
	 * 注册app
	 * 1，获取app的固定token在redis中查询
	 * 2，如果存在固定token，则允许继续访问
	 * 3，如果没有固定token，则拒绝访问
	 * @param joinPoint
	 */
	public void validateAppClient(JoinPoint joinPoint){
		
	}
}
