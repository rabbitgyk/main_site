package com.rabbit.site.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbit.site.constant.HandleStatus;
import com.rabbit.site.dao.BaseUserDao;
import com.rabbit.site.service.UserLoginService;
import com.rabbit.site.util.PasswordUtil;

/**
 *
 * @author rabbit
 * @date 2015年8月29日 下午11:27:25
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

	private Logger log = Logger.getLogger(UserLoginServiceImpl.class);
	@Autowired
	private BaseUserDao baseUserDao;
	
	@Override
	public int login(String userName, String password) {
		String salt = baseUserDao.findSalt(userName);
		String basePassword =baseUserDao.findPassword(userName);
		if(!validatePassword(basePassword, password, salt)){
			log.info("您输入的密码不正确！");
			return HandleStatus.FAIL;
		}
		log.info("您登陆成功！");
		return HandleStatus.SUCCESS;
	}
	
	private boolean validatePassword(String basePassword, String password, String salt){
		
		return PasswordUtil.validatePassword(basePassword, password + salt);
	}


}
