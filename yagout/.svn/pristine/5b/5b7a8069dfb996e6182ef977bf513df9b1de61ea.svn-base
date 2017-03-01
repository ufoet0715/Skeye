package com.skeye.yagout.service.impl;

import com.skeye.yagout.dal.dao.YagoutPermissionsDao;
import com.skeye.yagout.dal.dao.YagoutRolesDao;
import com.skeye.yagout.dal.dao.YagoutUsersDao;
import com.skeye.yagout.dal.model.YagoutUsers;
import com.skeye.yagout.dal.model.YagoutUsersExample;
import com.skeye.yagout.service.YagoutUsersService;
import com.skeye.yagout.util.CommonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class YagoutUsersServiceImpl implements YagoutUsersService {
	@Autowired private YagoutUsersDao usersDao;
	@Autowired	private YagoutRolesDao rolesDao;
	@Autowired private YagoutPermissionsDao permissionsDao;

	@Override
	public boolean userAddRole(Integer userId, Integer roleNo) {
		return rolesDao.userAddRole(userId, roleNo);
	}

	@Override
	public YagoutUsers getUserByName(String userName) {
		return usersDao.getUserByName(userName);
	}

	@Override
	public Set<String> getRolesByName(String userName) {
		return rolesDao.getRolesByName(userName);
	}

	@Override
	public boolean saveUser(YagoutUsers users) {
		return usersDao.saveUser(users);
	}

	@Override
	public boolean updatePwd(Integer id, String pwd) {
		YagoutUsers users=new YagoutUsers();
		users.setId(id);
		users.setPassword(pwd);
		return usersDao.updatePwd(users);
	}

	@Override
	public Set<String> getPermissionsByUserName(String userName) {
		return permissionsDao.getPermissionsByUserName(userName);
	}

	@Override
	public List<Map> queryUserByPage(CommonPage commonPage) {
		return  usersDao.getUserByMap(commonPage.pageToMap());

	}

	@Override
	public YagoutUsers getUserById(Integer userId) {

		return usersDao.getUserById(userId);
	}

	@Override
	public boolean deleteUsers(List<Integer> ids) {
		YagoutUsersExample example=new YagoutUsersExample();
		example.createCriteria().andIdIn(ids);
		int rows=usersDao.deleteUsers(example);
		return ids.size()>=rows&&rows>0;
	}
}
