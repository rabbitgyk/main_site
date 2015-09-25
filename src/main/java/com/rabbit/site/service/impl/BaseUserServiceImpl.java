package com.rabbit.site.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbit.site.dao.BaseUserDao;
import com.rabbit.site.model.BaseUser;
import com.rabbit.site.service.BaseUserService;

/**
 *
 * @author rabbit
 * @date 2015年9月22日 下午2:27:48
 */

@Service
public class BaseUserServiceImpl implements BaseUserService {

	@Autowired
	private BaseUserDao baseUserDao;
	
	@Override
	public List<BaseUser> getTops(int amount) {
		
		return baseUserDao.getTops(amount);
	}

	@Override
	public void add(BaseUser baseUser) {
		baseUserDao.insertUser(baseUser);
	}

}
