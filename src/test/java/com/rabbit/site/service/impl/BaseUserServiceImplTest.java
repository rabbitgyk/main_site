package com.rabbit.site.service.impl;

import org.junit.Before;
import org.junit.Test;

import com.rabbit.site.base.ApplicationContextHelper;
import com.rabbit.site.model.BaseUser;
import com.rabbit.site.service.BaseUserService;

/**
 *
 * @author rabbit
 * @date 2015年9月25日 上午11:14:43
 */
public class BaseUserServiceImplTest {
	
	private BaseUserService baseUserService;

	@Before
	public void init(){
		baseUserService = ApplicationContextHelper.getInstance("spring.xml").getBean(
				BaseUserService.class);
	}
	
	@Test
	public void testAdd() {
		BaseUser baseUser = new BaseUser();
		baseUser.setUserName("111111111");
		baseUser.setPassword("222222");
		baseUser.setSalt("23456789");
		baseUserService.add(baseUser);
	}

}
