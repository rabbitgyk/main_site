package com.rabbit.site.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rabbit.site.dao.BaseUserDao;

/**
 *
 * @author rabbit
 * @date 2015年8月29日 下午11:15:45
 */
@Repository
public class BaseUserDaoImpl implements BaseUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String findUserName(int id) {
		String sql = "select userName from baseuser where userId=?";
		Object[] params = {id};
		return jdbcTemplate.queryForObject(sql, params, String.class);
	}

}
