package com.skeye.yagout.service.impl;

import com.skeye.yagout.dal.dao.AccountDao;
import com.skeye.yagout.dal.model.Account;
import com.skeye.yagout.dal.model.AccountExample;
import com.skeye.yagout.dal.model.AccountExample.Criteria;
import com.skeye.yagout.service.AccountService;
import com.skeye.yagout.util.CommonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public int getCountByAccount(String accountName) {
        AccountExample accountExample = new AccountExample();
        Criteria criteria = accountExample.createCriteria();
        criteria.andAccountnameEqualTo(accountName);
        return this.accountDao.getAccountCount(accountExample);
    }

    @Override
    public List<Account> getAccountListByName(String accountName) {
        AccountExample accountExample = new AccountExample();
        Criteria criteria = accountExample.createCriteria();
        criteria.andAccountnameEqualTo(accountName);
        List<Account> accoutList = this.accountDao.getAccoutList(accountExample);
        return accoutList;
    }

    @Override
    public List<Map> getAccountListByLike(String accountName, String adslAccount, Integer rows) {
        Map<String, Object> map = new HashMap();
        map.put("accountName", accountName);
        map.put("lastCapADSL", adslAccount);
        map.put("getRows", rows);
        return accountDao.getAccoutListByMap(map);
    }

    @Override
    public List<Account> getAccountList() {
        AccountExample accountExample = new AccountExample();
        List<Account> accoutList = this.accountDao.getAccoutList(accountExample);
        return accoutList;
    }

    @Override
    public List<Map> getAccountListByPage(CommonPage commonPage) {
        return this.accountDao.getAccoutListByMap(commonPage.pageToMap());
    }

    @Override
    public boolean deleteAccountByList(List<Integer> ids) {
        AccountExample example = new AccountExample();
        example.createCriteria().andIdIn(ids);
        int rows = accountDao.deleteAccountByRecord(example);
        return ids.size() >= rows && rows > 0;
    }

}
