package com.yagout.defense.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yagout.defense.biz.bean.UserBean;
import com.yagout.defense.dal.model.User;
import com.yagout.defense.dal.model.UserExample;
import com.yagout.defense.util.CommonPage;

/**
 * Created by Skeyedu on 2017/2/7.
 */
public interface UserService {
    public User getUserByName(String userName);

    public Set<String> getRolesByName(String userName);

    public Set<String> getPermissionsByUserName(String userName);

    public List<Map<String,Object>> queryUserByPage(CommonPage commonPage);
    
    public List<UserBean> queryUsersList(UserExample example);

    public User getUserById(Integer userId);

    public boolean saveUser(User users);

    public boolean updatePwd(Integer id, String pwd);
    
    public boolean updateById(UserBean userBean);

    public boolean  userAddRole(Integer userId,Integer roleNo);

    public boolean deleteUsers(List<Integer> userIds);
    
    User getUserForLogin(String userName,String password);
}
