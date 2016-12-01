package com.hb.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.tomcat.util.http.mapper.Mapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.dodo.model.GuestVo;

public class GuestDao {
	
	private JdbcTemplate jdbcTemplate;
	private RowMapper<GuestVo> rowMapper;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public GuestDao() {
		rowMapper = new RowMapper<GuestVo>() {
			
			public GuestVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				GuestVo bean = new GuestVo(
						rs.getInt("sabun")
						, rs.getString("name")
						, rs.getDate("nalja")
						, rs.getInt("pay")
						);
				return bean;
			}
		};
	}
	
	public List<GuestVo> selectAll() {
		String sql = "select * from guest order by sabun";
		
		List list = jdbcTemplate.query(sql, rowMapper);
		return list;
	}

	public int insertOne(GuestVo bean) {
		
		String sql = "insert into guest values (?,?,sysdate,?)";
		
		Object[] obj = {bean.getSabun(),bean.getName(),bean.getPay()};
		return jdbcTemplate.update(sql,obj);
		
	}
	
	public int updateOne(GuestVo bean){
		
		String sql = "update guest set name=?,pay=? where sabun=?";
		
		Object[] obj = {bean.getName(),bean.getPay(),bean.getSabun()};
		return jdbcTemplate.update(sql,obj);
	}
	
	public int deleteOne(int sabun){
		
		String sql = "delete from guest where sabun=?";

		Object[] obj = {sabun};
		return jdbcTemplate.update(sql,obj);
	}

	public GuestVo selectOne(int sabun) {
		
		String sql = "select * from guest where sabun=?";
		
		Object[] obj = {sabun};
		
		return jdbcTemplate.queryForObject(sql, obj, rowMapper);
	}

}
