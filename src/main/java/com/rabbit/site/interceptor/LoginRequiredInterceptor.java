package com.rabbit.site.interceptor;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.rabbit.site.annotation.LoginRequired;
import com.rabbit.site.exception.LoginRequiredException;


/**
 * 登录拦截器
 * @author rabbit
 * @date 2015年8月12日 下午9:37:41
 */
public class LoginRequiredInterceptor extends HandlerInterceptorAdapter {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("annotation class:"+handler.getClass());
		System.out.println("annotation number:"+handler.getClass().getAnnotations().length);
		for(Annotation annotation : handler.getClass().getAnnotations()){
			if(annotation instanceof LoginRequired){ //检查必须登录的注解
				System.out.println("login required: ");
				HttpSession session = request.getSession();
				if(session.getAttribute("loginFlag") == null){
					boolean isAjax = Boolean.valueOf(request.getParameter("isAjax"));
					String message = null;
					if (isAjax) {
						JSONObject json = new JSONObject();
						json.put("code", "505");
						json.put("msg", "系统需要登录");
						message = json.toJSONString();
					} else {
						message = "/login/page" + "?f=" + request.getRequestURI();
					}
					//request.getRequestURI();
					throw new LoginRequiredException(isAjax, message);
				}
			}
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

}
