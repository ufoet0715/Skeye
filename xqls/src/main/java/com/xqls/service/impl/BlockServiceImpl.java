package com.xqls.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqls.bean.BlockBean;
import com.xqls.dal.dao.BlockDao;
import com.xqls.dal.model.Block;
import com.xqls.util.ObjectUtil;

@Service
public class BlockServiceImpl {

	@Autowired private BlockDao blockDao;
	
	public void add(BlockBean record){
		blockDao.insert((Block)ObjectUtil.transfer(record, Block.class));
		if(record.getBlockId() != null){
			
		}
	}
}
