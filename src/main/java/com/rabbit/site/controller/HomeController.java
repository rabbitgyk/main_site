package com.rabbit.site.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.rabbit.site.annotation.LoginRequired;

/**
 * 首页后台
 * @author rabbit
 * @date 2015年6月4日 下午11:57:28
 */
@Controller
@RequestMapping("/home")
@LoginRequired
public class HomeController {

	@RequestMapping("/page")
	public String helloWorld(HttpServletRequest request){
		request.setAttribute("username", "rabbit-guoyankui");
		return "/home";
	}
	
	@RequestMapping("/jingjing")
	public String jingjing(HttpServletRequest request){
		request.setAttribute("label", "jingjing");
		return "/jsp/jingjing";
	}
	
	@RequestMapping(value = "/info", method = {RequestMethod.POST})
	@ResponseBody
	public JSONObject info(HttpServletRequest request){
		JSONObject json = new JSONObject();
		json.put("name", "jingjing");
		json.put("old", 13);
		return json;
	}
	
	
}
