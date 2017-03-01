package com.yagout.defense.service.impl;

import com.yagout.defense.dal.dao.LoginCheckDao;
import com.yagout.defense.dal.model.LoginCheck;
import com.yagout.defense.dal.model.LoginCheckExample;
import com.yagout.defense.dal.model.LoginCheckExample.Criteria;
import com.yagout.defense.service.LoginCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginCheckServiceImpl implements LoginCheckService {

	@Autowired private LoginCheckDao loginCheckDao;
	
	@Override
	public boolean insertData(LoginCheck record) {
		return this.loginCheckDao.insertData(record);
	}

	@Override
	public boolean updateData(LoginCheck record) {
		return this.loginCheckDao.updateData(record);
	}
	
	@Override
	public boolean recoveLoginByList(List<Long> rowIdList) {
		return this.loginCheckDao.recoveLoginByList(rowIdList);
	}
	
	@Override
	public int countLoginCheckByExample(LoginCheck record) {
        LoginCheckExample example=new LoginCheckExample();
		
		Criteria criteria = example.createCriteria();
		criteria.andRowIdEqualTo(record.getRowId());
		criteria.andMacEqualTo(record.getMac());
	    criteria.andUserNameEqualTo(record.getUserName());
	    criteria.andCreateTimeEqualTo(record.getCreateTime());
	    criteria.andErrorNumEqualTo(record.getErrorNum());
		
		return this.loginCheckDao.getLoginCheckByExample(example).size();
	}
	
	@Override
	public List<LoginCheck> getLoginCheckByName(String userName) {
        LoginCheckExample example=new LoginCheckExample();
		
		Criteria criteria = example.createCriteria();
	    criteria.andUserNameEqualTo(userName);
		
		return this.loginCheckDao.getLoginCheckByExample(example);
	}

	@Override
	public List<LoginCheck> getLoginCheckByMac(String mac) {
        LoginCheckExample example=new LoginCheckExample();
		
		Criteria criteria = example.createCriteria();
		criteria.andMacEqualTo(mac);
		
		return this.loginCheckDao.getLoginCheckByExample(example);
	}

	@Override
	public List<LoginCheck> getLoginCheckByMap(Map<String, Object> map) {
		return this.loginCheckDao.getLoginCheckByMap(map);
	}

	@Override
	public List<LoginCheck> getLoginCheckForLogin(String userName, String mac) {
		Map<String, Object> map=new HashMap<String, Object>();
		//map.put("mac", mac); 注释mac查询
		map.put("userName", userName);
		return this.loginCheckDao.getLoginCheckForLogin(map);
	}
}
