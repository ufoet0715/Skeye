package com.skeye.yagout.dal.dao.mybatis;

import com.skeye.yagout.dal.dao.YagoutRolesDao;
import com.skeye.yagout.dal.model.YagoutUserRoleKey;
import com.skeye.yagout.dal.service.YagoutRolesMapper;
import com.skeye.yagout.dal.service.YagoutUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public class YagoutRolesDaoImpl implements YagoutRolesDao {
  @Autowired private YagoutRolesMapper  yagoutRolesMapper;
 @Autowired private YagoutUserRoleMapper yagoutUserRoleMapper;
	@Override
	public boolean userAddRole(Integer userId, Integer roleNo) {
		YagoutUserRoleKey roleKey=new YagoutUserRoleKey();
		roleKey.setRoleNo(roleNo);
		roleKey.setUserId(userId);
		int rows=yagoutUserRoleMapper.insert(roleKey);
		return rows>0;
	}

	@Override
	public Set<String> getRolesByName(String userName) {
		return yagoutRolesMapper.getRolesByName(userName);
	}

}
