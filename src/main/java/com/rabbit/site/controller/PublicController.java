package com.rabbit.site.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 公告页
 * @author rabbit
 * @date 2015年6月4日 下午11:57:28
 */
@Controller
@RequestMapping("/public")
public class PublicController {
	
	private Logger log = Logger.getLogger(PublicController.class);

	@RequestMapping("/page")
	public String helloWorld(HttpServletRequest request){
		request.setAttribute("username", "rabbit-guoyankui");
		return "/public";
	}
	
	@RequestMapping(value="/params", method=RequestMethod.GET, params="myParam=myValue")
	@ResponseBody
	public String paramsInterceptor(HttpServletRequest request, HttpServletResponse response){
		log.info("params interceptor ...");
		
		return "ooooo";
	}
	
}
