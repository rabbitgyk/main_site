package com.rabbit.site.service;
/**
 * 用户注册
 * @author rabbit
 * @date 2015年9月24日 上午9:09:45
 */
public interface UserRegisterService {

	public Integer register(String userName, String password, String password2);
}
