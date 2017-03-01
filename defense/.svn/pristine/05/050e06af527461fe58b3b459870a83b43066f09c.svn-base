package com.yagout.dao;

import com.yagout.BasicTest;
import com.yagout.defense.dal.dao.UsersDao;
import com.yagout.defense.dal.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Skeyedu on 2017/2/9.
 */
public class UsersDaoTest extends BasicTest {

  @Autowired  private UsersDao usersDao;

    @Test
    public  void  yt(){
        User user=usersDao.getUserById(1);
        System.out.println(user==null);
    }
}
