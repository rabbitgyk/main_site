package com.rabbit.site.service.impl;

import org.junit.Before;
import org.junit.Test;

import com.rabbit.site.base.ApplicationContextHelper;
import com.rabbit.site.service.UserRegisterService;

/**
 *
 * @author rabbit
 * @date 2015年9月24日 下午2:09:33
 */
public class UserRegisterServiceImplTest {

	private UserRegisterService userRegisterService;
	
	@Before
	public void init(){
		userRegisterService = ApplicationContextHelper.getInstance("spring.xml").getBean(
				UserRegisterService.class);
	}
	
	@Test
	public void testRegister() {
		
		userRegisterService.register("guoyankui1", "123456", "123456");
	}

}
