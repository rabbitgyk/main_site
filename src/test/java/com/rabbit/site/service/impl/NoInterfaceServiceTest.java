package com.rabbit.site.service.impl;

import org.junit.Before;
import org.junit.Test;

import com.rabbit.site.base.ApplicationContextHelper;
import com.rabbit.site.model.BaseUser;

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
		BaseUser bu = new BaseUser();
		bu.setUserName("insertTest");
		bu.setPassword("38834993002032488");
		bu.setSalt("djueru38");
		bu.setExtra("hehhe");
		noInterfaceService.addPerson("xiaoxiami", "add Two", bu);
	}
	
	@Test
	public void testDelete(){
		noInterfaceService.deletePerson("person");
	}
	
	@Test
	public void testEdit(){
		noInterfaceService.editPerson("editPerson");
	}

}
