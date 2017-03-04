package com.xqls.dal.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xqls.dal.dao.BlockDao;
import com.xqls.dal.model.Block;
import com.xqls.dal.model.BlockExample;
import com.xqls.dal.service.BlockMapper;

@Repository
public class BlockDaoImpl implements BlockDao{

	@Autowired private BlockMapper blockMapper;
	
	public int insert(Block record){
		return blockMapper.insertReturnKey(record);
	}
	
	public boolean update(Block record){
		return blockMapper.updateByPrimaryKeySelective(record)>0;
	}
	
	public boolean delete(Integer blockId){
		return blockMapper.deleteByPrimaryKey(blockId)>0;
	}
	
	public boolean deleteList(List<Integer> values){
		BlockExample example = new BlockExample();
		example.createCriteria().andBlockIdIn(values);
		return blockMapper.deleteByExample(example)>0;
	}
	
	public Block queryByKey(Integer blockId){
		return blockMapper.selectByPrimaryKey(blockId);
	}
	
	public List<Block> queryByExample(BlockExample example){
		return blockMapper.selectByExample(example);
	}
}
