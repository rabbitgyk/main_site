package com.rabbit.site.dao.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rabbit.site.base.ApplicationContextHelper;
import com.rabbit.site.dao.BaseUserDao;

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
		String userName = baseUserDao.findUserName(1);
		assertEquals("rabbit", userName);
	}

}
