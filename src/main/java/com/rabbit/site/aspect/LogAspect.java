package com.rabbit.site.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 记录log日志的切面
 * @author rabbit
 * @date 2015年9月4日 下午6:31:51
 */
@Component
@Aspect
public class LogAspect {
	
	@Pointcut("execution(* *.add(..))")
	public void pointCut_add(){
		
	}
	
	@Before("pointCut_add() && args(obj)")
	public void beforeAdd(Object obj){
		System.out.println("add before !!!" + obj.getClass().getName());
		System.out.println("add before !!!" + obj.toString());
	}

}
