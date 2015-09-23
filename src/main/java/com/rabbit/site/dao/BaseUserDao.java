package com.rabbit.site.dao;

import java.util.List;

import com.rabbit.site.model.BaseUser;

/**
 *
 * @author rabbit
 * @date 2015年8月29日 下午11:14:46
 */
public interface BaseUserDao {
	
	public String findUserName(int id);
	
	public int insertUser(BaseUser baseUser);
	
	public int[] batchInsert(final List<BaseUser> list);
	
	public List<BaseUser> getTops(int amount);
	
	

}
