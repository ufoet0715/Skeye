package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.LoginCheckDao;
import com.yagout.defense.dal.model.LoginCheck;
import com.yagout.defense.dal.model.LoginCheckExample;
import com.yagout.defense.dal.service.LoginCheckMapper;

@Repository
public class LoginCheckDaoImpl implements LoginCheckDao {

	@Autowired private LoginCheckMapper loginCheckMapper;
	
	@Override
	public boolean insertData(LoginCheck record) {
		boolean result=false;
		if(this.loginCheckMapper.insert(record)>0)
		{
			result=true;
		}
		return result;
	}

	@Override
	public boolean updateData(LoginCheck record) {
		boolean result=false;
		if(this.loginCheckMapper.updateByPrimaryKey(record)>0)
		{
			result=true;
		}
		return result;
	}

	@Override
	public boolean recoveLoginByList(List<Long> rowIdList){
		boolean result=false;
		if(this.loginCheckMapper.recoveLoginByList(rowIdList)>0)
		{
			result=true;
		}
		return result;
	}
	
	@Override
	public List<LoginCheck> getLoginCheckByExample(LoginCheckExample example) {
		return this.loginCheckMapper.selectByExample(example);
	}

	@Override
	public List<LoginCheck> getLoginCheckByMap(Map<String, Object> map) {
		return this.loginCheckMapper.getLoginCheckByMap(map);
	}

	@Override
	public List<LoginCheck> getLoginCheckForLogin(Map<String, Object> map) {
		return this.loginCheckMapper.getLoginCheckForLogin(map);
	}

}
