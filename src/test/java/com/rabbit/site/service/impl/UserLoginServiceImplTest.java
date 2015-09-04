package com.rabbit.site.service.impl;

import org.junit.Before;
import org.junit.Test;

import com.rabbit.site.base.ApplicationContextHelper;
import com.rabbit.site.service.UserLoginService;

/**
 *
 * @author rabbit
 * @date 2015年9月5日 上午12:54:13
 */
public class UserLoginServiceImplTest {
	
	private UserLoginService userLoginService;
	
	@Before
	public void init(){
		userLoginService = ApplicationContextHelper.getInstance("spring.xml").getBean(
				UserLoginService.class);
	}

	@Test
	public void test() {
		userLoginService.add("123");
	}

}
