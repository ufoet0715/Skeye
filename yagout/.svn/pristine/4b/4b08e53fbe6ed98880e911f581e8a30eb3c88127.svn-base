package com.skeye.yagout.dal.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skeye.yagout.dal.dao.SystemadminDao;
import com.skeye.yagout.dal.model.Systemadmin;
import com.skeye.yagout.dal.service.SystemadminMapper;

@Repository
public class SystemadminDaoImpl implements SystemadminDao {

	@Autowired private SystemadminMapper systemadminMapper;
	
	@Override
	public boolean addSystemadmin(Systemadmin record) {
		 int rows=systemadminMapper.insertSelective(record);
		return rows>0;
	}

}
