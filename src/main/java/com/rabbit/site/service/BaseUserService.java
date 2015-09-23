package com.rabbit.site.service;

import java.util.List;

import com.rabbit.site.model.BaseUser;

/**
 *
 * @author rabbit
 * @date 2015年9月22日 下午2:26:18
 */
public interface BaseUserService {

	public List<BaseUser> getTops(int amount);
}
