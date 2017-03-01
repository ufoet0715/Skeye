package com.yagout.defense.service.impl;

import com.yagout.defense.biz.bean.UserBean;
import com.yagout.defense.dal.dao.UserRoleDao;
import com.yagout.defense.dal.dao.UsersDao;
import com.yagout.defense.dal.model.User;
import com.yagout.defense.dal.model.UserExample;
import com.yagout.defense.dal.model.UserExample.Criteria;
import com.yagout.defense.service.UserService;
import com.yagout.defense.util.CommonPage;
import com.yagout.defense.util.ObjectUtil;
import com.yagout.defense.util.UserEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Skeyedu on 2017/2/7.
 */
@Service
public class UserServiceImpl implements UserService {
//    @Autowired
//    private YagoutUsersDao usersDao;
//    @Autowired	private YagoutRolesDao rolesDao;
//    @Autowired private YagoutPermissionsDao permissionsDao;
    @Autowired private UsersDao userDao;
    @Autowired private UserRoleDao userRoleDao;
    
    @Override
    public boolean userAddRole(Integer userId, Integer roleId) {
        return userRoleDao.insertUserRole(userId, roleId);
    }

    @Override
    public User getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Override
    public Set<String> getRolesByName(String userName) {
        return null;
      //  return rolesDao.getRolesByName(userName);
    }

    @Override
    public boolean saveUser(User users) {
        return userDao.saveUser(users);
    }

    @Override
    public boolean updatePwd(Integer id, String pwd) {
        User  users=new User();
        users.setUserId(id);
        users.setUserPwd(pwd);
        return userDao.updatePwd(users);
    }
    
    public boolean updateById(UserBean userBean){
    	boolean success = false;
        if(userBean.getRoleId()!=null){
            success = userRoleDao.updateRole(userBean.getUserId(),userBean.getRoleId());
        }else {
            success=true;
        }

    	if(success){
    		success = userDao.updateById((User)ObjectUtil.transfer(userBean, User.class));
    	}
    	return success;
    }

    @Override
    public Set<String> getPermissionsByUserName(String userName) {

      return  null;
      //  return permissionsDao.getPermissionsByUserName(userName);
    }

    @Override
    public List<Map<String,Object>> queryUserByPage(CommonPage commonPage) {
        return  userDao.getUserByMap(commonPage.pageToMap());

    }

    @Override
    public User getUserById(Integer userId) {

        return userDao.getUserById(userId);
    }

    @Override
    public boolean deleteUsers(List<Integer> ids) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("state", UserEnums.ABNORMALSTATE.getCode());
    	map.put("userIdList", ids);
        return userDao.deleteUsers(map);
    }
    
    @SuppressWarnings("unchecked")
	public List<UserBean> queryUsersList(UserExample example){
    	 return ObjectUtil.transferList(userDao.queryUsersList(example), UserBean.class);
    }

	@Override
	public User getUserForLogin(String userName, String password) {
		User user=null;
		
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		criteria.andUserPwdEqualTo(password);
		
		List<User> userList = this.userDao.getUserForLogin(example);
		if (userList.size() > 0) {
			user=userList.get(0);
		}
		return user;
	}
	
}
