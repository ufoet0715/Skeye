package com.skeye.yagout.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skeye.yagout.dal.dao.RawaccountHandledTwoDao;
import com.skeye.yagout.dal.model.RawaccountHandledTwo;
import com.skeye.yagout.service.RawaccountHandledTwoService;

@Service
public class RawaccountHandledTwoServiceImpl implements RawaccountHandledTwoService {
	@Autowired private RawaccountHandledTwoDao rawaccountHandledTwoDao;
	
    @Override
	public List<RawaccountHandledTwo> getAll() {
		return this.rawaccountHandledTwoDao.getAll();
	}

}
