package com.skeye.yagout.dal.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skeye.yagout.dal.dao.AccountDao;
import com.skeye.yagout.dal.model.Account;
import com.skeye.yagout.dal.model.AccountExample;
import com.skeye.yagout.dal.model.AccountExample.Criteria;
import com.skeye.yagout.dal.service.AccountMapper;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired private AccountMapper accountMapper;

	@Override
	public List<Account> getAccoutList(AccountExample accountExample) {
		return this.accountMapper.selectByExample(accountExample);
	}

	@Override
	public int getAccountCount(AccountExample accountExample) {
		return this.accountMapper.countByExample(accountExample);
	}

	@Override
	public List<Map> getAccoutListByMap(Map<String, Object> paramMap) {
		return this.accountMapper.selectByMap(paramMap);
	}

	@Override
	public int deleteAccountByRecord(AccountExample accountExample) {
		return this.accountMapper.deleteByExample(accountExample);
	}

}
