package com.skeye.yagout.dal.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skeye.yagout.dal.dao.RawaccountHandledTwoDao;
import com.skeye.yagout.dal.model.RawaccountHandledTwo;
import com.skeye.yagout.dal.service.RawaccountHandledTwoMapper;

@Repository
public class RawaccountHandledTwoDaoImpl implements RawaccountHandledTwoDao {
	@Autowired private RawaccountHandledTwoMapper rawaccountHandledTwoMapper;
	
    @Override
	public List<RawaccountHandledTwo> getAll() {
		return this.rawaccountHandledTwoMapper.selectAll();
	}

}
