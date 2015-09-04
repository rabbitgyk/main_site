package com.rabbit.site.service.impl;

import org.junit.Before;
import org.junit.Test;

import com.rabbit.site.base.ApplicationContextHelper;

/**
 * 无接口的类依然能够使用aop
 * @author rabbit
 * @date 2015年9月5日 上午1:10:15
 */
public class NoInterfaceServiceTest {

private NoInterfaceService noInterfaceService;
	
	@Before
	public void init(){
		noInterfaceService = ApplicationContextHelper.getInstance("spring.xml").getBean(
				NoInterfaceService.class);
	}

	@Test
	public void test() {
		noInterfaceService.add("nono");
	}

}
