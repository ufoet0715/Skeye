package com.yagout.defense.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yagout.defense.dal.dao.UsersDao;
import com.yagout.defense.dal.model.User;
import com.yagout.defense.dal.model.UserExample;
import com.yagout.defense.dal.service.UserMapper;
import com.yagout.defense.util.UserEnums;
@Repository
public class UsersDaoImpl implements UsersDao {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserByName(String userName) {
        UserExample example=new UserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        List< User> users=userMapper.selectByExample(example);
        if(users!=null&&users.size()>0) return users.get(0);
        return null;
    }

    @Override
    public User getUserById(Integer userId) {
        return 	userMapper.selectByPrimaryKey(userId);
    }
    
    public boolean updateById(User user){
    	user.setState(UserEnums.ABNORMALSTATE.getCode());
    	int rows=userMapper.updateByPrimaryKeySelective(user);
        return rows>0;
    }

    @Override
    public List<Map<String,Object>> getUserByMap(Map<String, Object> map) {
        return userMapper.getUserByMap(map);
    }

    @Override
    public boolean saveUser(User users) {
        int rows=userMapper.insertSelective(users);
        return rows>0;
    }

    @Override
    public boolean updatePwd(User users) {
        int rows=userMapper.updateByPrimaryKeySelective(users);
        return rows>0;
    }

    @Override
    public boolean deleteUsers(Map<String, Object> map) {
        return userMapper.deleteUserList(map)>0;
    }
    
    @Override
    public List<User> queryUsersList(UserExample example){
    	return userMapper.selectByExample(example);
    }

	@Override
	public List<User> getUserForLogin(UserExample example) {
		return this.userMapper.selectByExample(example);
	}
}
