package com.rabbit.site.exceptionHandler;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.rabbit.site.exception.LoginRequiredException;


/**
 * 全局统一异常处理器
 * @author rabbit
 * @date 2015年8月12日 下午10:43:16
 */
public class ShareHandlerExceptionResolver implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		if (ex instanceof LoginRequiredException) {
			try {
				if (((LoginRequiredException) ex).isAjax()) {
					response.setCharacterEncoding("UTF-8");
			        response.setHeader("Content-type", "text/html;charset=UTF-8");
					response.getWriter().write(ex.getMessage());
					response.getWriter().flush();
					System.out.println("全局捕获到异常。。。");
				} else {
					HashMap<String, Object> model = new HashMap<String, Object>();
					
					return new ModelAndView("redirect:" + ex.getMessage(), model);
				}
			} catch (IOException e) {
				System.out.println("拦截到错误：" + request.getRequestURI());
			}
			return null;
		}
		boolean isAjax = Boolean.valueOf(request.getParameter("isAjax"));
		if (isAjax) {
			JSONObject json = new JSONObject();
			json.put("code", "505");
			json.put("msg", "系统异常，统一捕获...");
			try {
				response.setCharacterEncoding("UTF-8");
		        response.setHeader("Content-type", "text/html;charset=UTF-8");
				response.getWriter().write(json.toJSONString());
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		} else {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("500");
			
			return mav;
		}
	}
	
	static enum RequestResultFormat{
		PAGE(0), //NL 返回页面
		JSON(1); //返回
		private int format;
		private RequestResultFormat(int format){
			this.format = format;
		}
		
		public static RequestResultFormat getResultFormat(int format){
			RequestResultFormat prf = RequestResultFormat.PAGE;
			if(format ==JSON.format ){
				prf = RequestResultFormat.JSON;
			}
			return prf;
		}
	}

}
