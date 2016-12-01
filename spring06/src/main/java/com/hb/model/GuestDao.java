package com.hb.model;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

public class GuestDao extends SqlMapClientDaoSupport{
	
	public List<GuestVo> selectAll(){
		
		SqlMapClientTemplate template = getSqlMapClientTemplate();
		
		return template.queryForList("selectAll");
	}
	
	public void insertOne(GuestVo bean){
		SqlMapClientTemplate template = getSqlMapClientTemplate();
		template.insert("insertOne",bean);
	}
	
	public GuestVo selectOne(int sabun){
		SqlMapClientTemplate template = getSqlMapClientTemplate();
		return (GuestVo)template.queryForObject("selectOne", sabun);
	}
	
	public void updateOne(GuestVo bean){
		SqlMapClientTemplate template = getSqlMapClientTemplate();
		template.update("updateOne", bean);
	}
	
	
	public void deleteOne(int sabun){
		SqlMapClientTemplate template = getSqlMapClientTemplate();
		template.delete("deleteOne", sabun);
	}
}
