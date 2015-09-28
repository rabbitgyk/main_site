package com.rabbit.site.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
	public void pointCut_log() {
	}
	
	@Around("pointCut_log()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		String className = pjp.getSignature().getDeclaringTypeName();
		String methodName = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		log.info(String.format("className:%s,methodName:%s,args:%s", className, methodName, JSONObject.toJSONString(args)));
		try {
			Object returnVal = pjp.proceed();
			log.info(String.format("className:%s,methodName:%s,return:%s", className, methodName, JSONObject.toJSONString(returnVal)));
		} catch (Throwable ex) {
			log.error(String.format("className:%s,methodName:%s,exception:", className, methodName), ex);
			throw ex;
		}
	}

}
