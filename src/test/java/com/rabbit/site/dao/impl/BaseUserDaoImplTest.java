package com.rabbit.site.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.rabbit.site.base.ApplicationContextHelper;
import com.rabbit.site.dao.BaseUserDao;
import com.rabbit.site.model.BaseUser;

/**
 *
 * @author rabbit
 * @date 2015年8月30日 上午12:02:16
 */
public class BaseUserDaoImplTest {
	
	private BaseUserDao baseUserDao;
	
	@Before
	public void init() {
		baseUserDao = ApplicationContextHelper.getInstance("spring.xml").getBean(
				BaseUserDao.class);
	}

	@Test
	public void findUserName() {
		String userName = baseUserDao.findUserName(10001);
		System.out.println("return : " + userName);
		//assertEquals("rabbit", userName);
	}
	
	@Test
	public void insertUser() {
		BaseUser bu = new BaseUser();
		bu.setUserName("insertTest");
		bu.setPassword("38834993002032488");
		bu.setSalt("djueru38");
		bu.setExtra("hehhe");
		baseUserDao.insertUser(bu);
	}
	
	@Test
	public void batchInsert(){
		List<BaseUser> list = new ArrayList<BaseUser>();
		for(int i=0; i<10000; i++){
			BaseUser bu = new BaseUser();
			bu.setUserName("batchUser"+i);
			bu.setPassword("38834993002032488");
			bu.setSalt("djueru38");
			bu.setExtra("hehhe");
			list.add(bu);
		}
		baseUserDao.batchInsert(list);
	}
	
	@Test
	public void getTops(){
		List<BaseUser> list = baseUserDao.getTops(1000);
		System.out.println(list.size());
	}

}
