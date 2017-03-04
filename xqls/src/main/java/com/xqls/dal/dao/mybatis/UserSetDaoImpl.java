package com.xqls.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xqls.dal.dao.UserSetDao;
import com.xqls.dal.model.UserSet;
import com.xqls.dal.service.UserSetMapper;

@Repository
public class UserSetDaoImpl implements UserSetDao {

	@Autowired private UserSetMapper userSetMapper;
	
	@Override
	public List<UserSet> getListByMap(Map<String, Object> map) {
		return this.userSetMapper.getListByMap(map);
	}
}
