package com.rabbit.site.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

/**
 * 测试学习aspect切面
 * 
 * @author rabbit
 * @date 2015年9月28日 上午9:51:04
 */
@Component
@Aspect
public class TestAllAspect {

	@Pointcut("execution(* comn.rabbit.site.service.impl.*Service*.*(..))")
	public void pointCut() {
	}

	@After("pointCut()")
	public void after(JoinPoint joinPoint) {
		System.out.println("after aspect executed");
	}

	@Before("pointCut()")
	public void before(JoinPoint joinPoint) {
		// 如果需要这里可以取出参数进行处理
		Object[] args = joinPoint.getArgs();
		System.out.println("before aspect executing"+JSONObject.toJSONString(args));
	}
	
//	@Before("pointCut() && args(obj)")
//	public void beforeFind(Object obj){
//		System.out.println("add before !!!" + obj.getClass().getName());
//		System.out.println("add before !!!" + obj.toString());
//	}

	@AfterThrowing(pointcut = "pointCut()", throwing = "error")
	public void afterThrowing(JoinPoint jp, Throwable error) {
		System.out.println("error:" + error);
	}
	
	@AfterReturning(pointcut = "pointCut()", returning = "returnVal")
	public void afterReturning(JoinPoint joinPoint, Object returnVal) {
		//获取返回参数，获取不到
		System.out.println("afterReturning executed, return result is "
				+ returnVal);
	}
	
	
	@Around("pointCut()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around start..");
		try {
			System.out.println("around before:"+JSONObject.toJSONString(pjp.getArgs()));
			Object o = pjp.proceed();
			System.out.println("around end:"+JSONObject.toJSONString(o));
		} catch (Throwable ex) {
			System.out.println("error in around");
			throw ex;
		}
		System.out.println("around end");
	}

}
