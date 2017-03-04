package com.xqls.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.dal.dao.UserSetDao;
import com.xqls.dal.model.UserSet;
import com.xqls.service.UserSetService;

@Service
public class UserSetServiceImpl implements UserSetService {

	@Autowired private UserSetDao userSetDao;
	
	@Override
	public List<UserSet> getListByMap(Map<String, Object> map) {
		return this.userSetDao.getListByMap(map);
	}
}
