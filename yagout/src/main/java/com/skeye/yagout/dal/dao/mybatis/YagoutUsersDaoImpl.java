package com.skeye.yagout.dal.dao.mybatis;

import com.skeye.yagout.dal.dao.YagoutUsersDao;
import com.skeye.yagout.dal.model.YagoutUsers;
import com.skeye.yagout.dal.model.YagoutUsersExample;
import com.skeye.yagout.dal.service.YagoutUsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class YagoutUsersDaoImpl implements YagoutUsersDao {
   
	@Autowired private YagoutUsersMapper yagoutUsersMapper;
	@Override
	public YagoutUsers getUserByName(String userName) {
		YagoutUsersExample example=new YagoutUsersExample();
		example.createCriteria().andUserNameEqualTo(userName);
		List<YagoutUsers> users=yagoutUsersMapper.selectByExample(example);
		if(users!=null&&users.size()>0) return users.get(0);
		return null;
	}

	@Override
	public YagoutUsers getUserById(Integer userId) {
		return 	yagoutUsersMapper.selectByPrimaryKey(userId);
	}

	@Override
	public List<Map> getUserByMap(Map<String, Object> map) {
		return yagoutUsersMapper.getUserByMap(map);
	}

	@Override
	public boolean saveUser(YagoutUsers users) {
		int rows=yagoutUsersMapper.insertSelective(users);
		return rows>0;
	}

	@Override
	public List<YagoutUsers> getUserByExamle(YagoutUsersExample example) {
		return yagoutUsersMapper.selectByExample(example);
	}

	public  boolean updatePwd(YagoutUsers users){
		int rows=yagoutUsersMapper.updateByPrimaryKeySelective(users);
		return rows>0;

	}

	public int deleteUsers(YagoutUsersExample example){
		return yagoutUsersMapper.deleteByExample(example);
	}
}
