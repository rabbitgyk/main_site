package com.rabbit.site.service.impl;

import org.springframework.stereotype.Service;

import com.rabbit.site.service.UserLoginService;

/**
 *
 * @author rabbit
 * @date 2015年8月29日 下午11:27:25
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Override
	public String getSalt(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(String user) {
		System.out.println("add a user!");
		
	}

}
