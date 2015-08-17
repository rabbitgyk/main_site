package com.rabbit.site.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

/**
 * 登录
 * @author rabbit
 * @date 2015年6月4日 下午11:57:28
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/page")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		System.out.println("login page ...");
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("label", "test 登录");
		model.put("refer", request.getParameter("f"));
		return new ModelAndView("/jsp/login", model);
	}
	
	@RequestMapping(value = "/post", method = { RequestMethod.POST })
	@ResponseBody
	public JSONObject loginPost(HttpServletRequest request, HttpServletResponse response){
		System.out.println("login post...");
		String userName = request.getParameter("userName");
		String password  = request.getParameter("password");
		HttpSession session = request.getSession();
		JSONObject json = new JSONObject();
		if(checkLogin(userName, password)){
			session.setAttribute("loginFlag", "isLogin");
			json.put("code", "1");
			json.put("msg", "登录成功！");
			return json;
		}
		json.put("code", "0");
		json.put("msg", "登录失败！");
		return json;
	}
	
	/**
	 * 登录用户信息校验
	 * @param userName
	 * @param password
	 * @return
	 */
	private boolean checkLogin(String userName, String password){
		if(userName != null && password != null){
			if(userName.equals("rabbit") && password.equals("123")){
				return true;
			}
		}
		return false;
	}
}
