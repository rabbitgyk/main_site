package com.rabbit.site.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rabbit.site.dao.BaseUserDao;
import com.rabbit.site.model.BaseUser;
import com.rabbit.site.util.CollectionUtil;

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

	@Override
	public int insertUser(BaseUser baseUser) {
		String sql = "insert into baseuser (userName, password, extra, salt) values (?, ?, ?, ?)";
		Object[] params = {baseUser.getUserName(), baseUser.getPassword(), baseUser.getExtra(), baseUser.getSalt()};
		return jdbcTemplate.update(sql, params);
	}
	
	@Override
	public int[] batchInsert(List<BaseUser> list) {
		String sql = "insert into baseuser (userName, password, extra, salt) values (?, ?, ?, ?)";
		String[] fieldNames = {"userName", "password", "extra", "salt"};
		List<Object[]> batchParams = CollectionUtil.objListToObjArrayList(list, fieldNames);
		return jdbcTemplate.batchUpdate(sql, batchParams);
	}

	@Override
	public List<BaseUser> getTops(int amount) {
		String sql = "select * from baseuser order by userId limit ?";
		Object[] params = {amount};
		return jdbcTemplate.query(sql, params, new BaseUserRowMapper());
	}

	
	/**
	 * 数据库表baseuser和BaseUser对象的mapper关系
	 * @author rabbit
	 *
	 */
	protected class BaseUserRowMapper implements RowMapper<BaseUser>{
		@Override
		public BaseUser mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			BaseUser baseUser=new BaseUser();
			baseUser.setUserId(rs.getInt("userId"));
			baseUser.setUserName(rs.getString("userName"));
			baseUser.setPassword(rs.getString("password"));
			baseUser.setSalt(rs.getString("salt"));
			baseUser.setExtra(rs.getString("extra"));
            return baseUser;
		}
	}
	

}
