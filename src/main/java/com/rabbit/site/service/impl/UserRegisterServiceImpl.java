package com.rabbit.site.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbit.site.constant.HandleStatus;
import com.rabbit.site.dao.BaseUserDao;
import com.rabbit.site.model.BaseUser;
import com.rabbit.site.service.UserRegisterService;
import com.rabbit.site.util.PasswordUtil;
import com.rabbit.site.util.RandomUtil;

/**
 * 用户注册服务
 * @author rabbit
 * @date 2015年9月24日 上午9:13:50
 */
@Service
public class UserRegisterServiceImpl implements UserRegisterService {

	private Logger log = Logger.getLogger(UserRegisterServiceImpl.class);
	@Autowired
	private BaseUserDao baseUserDao;
	
	@Override
	public Integer register(String userName, String password, String password2) {
		//用户是否已经被注册
		if(baseUserDao.countUser(userName) > 0){
			log.info("该用户名已经被注册了！" + userName);
			return HandleStatus.FAIL;
		}
		//二次确认密码
		if(!password.equals(password2)){
			log.info("确认密码不正确！");
			return HandleStatus.FAIL;
		}
		//创建用户
		BaseUser baseUser = new BaseUser();
		baseUser.setUserName(userName);
		String salt = RandomUtil.getRandString(8);
		baseUser.setSalt(salt);
		baseUser.setPassword(PasswordUtil.generatePassword(password + salt));
		baseUser.setExtra("无备注");
		baseUserDao.insertUser(baseUser);
		
		return HandleStatus.SUCCESS;
	}

}
