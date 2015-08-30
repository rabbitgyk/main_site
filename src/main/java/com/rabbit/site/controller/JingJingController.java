package com.rabbit.site.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rabbit.site.annotation.LoginRequired;

/**
 * 静静功能页
 * @author rabbit
 * @date 2015年6月4日 下午11:57:28
 */
@Controller
@RequestMapping("/jingjing")
@LoginRequired
public class JingJingController {

	@RequestMapping("/page")
	public String jingjing(HttpServletRequest request){
		request.setAttribute("label", "jingjing");
		return "/jsp/jingjing";
	}
	
	
}
