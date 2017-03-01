package com.skeye.yagout.dal.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skeye.yagout.dal.dao.AccountTwoDao;
import com.skeye.yagout.dal.model.AccountTwo;
import com.skeye.yagout.dal.service.AccountTwoMapper;

@Repository
public class AccountTwoDaoImpl implements AccountTwoDao {
	@Autowired private AccountTwoMapper accountTwoMapper;
	
    @Override
	public List<AccountTwo> getAll() {
		return this.accountTwoMapper.selectAll();
	}

}
