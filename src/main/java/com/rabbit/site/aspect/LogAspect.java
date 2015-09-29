package com.rabbit.site.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

/**
 * 记录log日志的切面
 * @author rabbit
 * @date 2015年9月4日 下午6:31:51
 */
@Component
@Aspect
public class LogAspect {
	
	private Logger log = Logger.getLogger(LogAspect.class);
	
	@Pointcut("execution(* com.rabbit.site.service.impl.*Service*.*(..))")
	public void serviceLog() {
	}
	
	@Pointcut("execution(* com.rabbit.site.dao.impl.*Dao*.*(..))")
	public void daoLog() {
	}
	
	@Pointcut("execution(* com.rabbit.site.dao.impl.BaseUserDaoImpl.findUserName(..))")
	public void findUserNameDaoLog(){
	}
	
	@Before("findUserNameDaoLog()")
	public void before(JoinPoint joinPoint) {
		// 如果需要这里可以取出参数进行处理
		Object[] args = joinPoint.getArgs();
		System.out.println("before aspect executing"+JSONObject.toJSONString(args));
	}
	
	@Around("serviceLog() || daoLog()")
	public Object aroundService(ProceedingJoinPoint pjp) throws Throwable {
		String className = pjp.getSignature().getDeclaringTypeName();
		String methodName = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		log.info(String.format("className:%s,methodName:%s,args:%s", className, methodName, JSONObject.toJSONString(args)));
		Object returnVal = null;
		try {
			returnVal = pjp.proceed();
			log.info(String.format("className:%s,methodName:%s,return:%s", className, methodName, JSONObject.toJSONString(returnVal)));
		} catch (Throwable ex) {
			log.error(String.format("className:%s,methodName:%s,exception:", className, methodName), ex);
			throw ex;
		}
		return returnVal ;
	}
	
	
}
