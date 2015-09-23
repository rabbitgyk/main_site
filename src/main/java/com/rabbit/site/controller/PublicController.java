package com.rabbit.site.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rabbit.site.model.BaseUser;
import com.rabbit.site.service.BaseUserService;

/**
 * 公告页
 * @author rabbit
 * @date 2015年6月4日 下午11:57:28
 */
@Controller
@RequestMapping("/public")
public class PublicController {
	
	private Logger log = Logger.getLogger(PublicController.class);
	
	@Autowired
	private BaseUserService baseUserService;

	@RequestMapping("/page")
	public String helloWorld(HttpServletRequest request){
		request.setAttribute("username", "rabbit-guoyankui");
		return "/view/public";
	}
	
	@RequestMapping(value="/params", method=RequestMethod.GET, params="myParam=myValue")
	@ResponseBody
	public String paramsInterceptor(HttpServletRequest request, HttpServletResponse response){
		log.info("params interceptor ...");
		
		return "ooooo";
	}
	
	@RequestMapping(value="/baseUsers", method=RequestMethod.GET)
	@ResponseBody
	public List<BaseUser> baseUsersr(HttpServletRequest request, HttpServletResponse response){
		log.info("test baseUser ...");
		int amount = Integer.parseInt(request.getParameter("amount"));
		return baseUserService.getTops(amount);
	}
	
}
