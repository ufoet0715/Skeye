package com.xqls.dal.dao;

import java.util.List;

import com.xqls.dal.model.Block;
import com.xqls.dal.model.BlockExample;

public interface BlockDao {

	/**
	 * 添加
	 * @param record 区块对象
	 * @return 返回主键
	 */
	public int insert(Block record);
	
	/**
	 * 根据ID修改
	 * @param record 区块对象
	 * @return 返回修改结果
	 */
	public boolean update(Block record);
	
	/**
	 * 根据ID删除
	 * @param blockId 区块编号
	 * @return 返回删除结果
	 */
	public boolean delete(Integer blockId);
	
	/**
	 * 批量删除
	 * @param values 区块编号集合
	 * @return 返回删除结果
	 */
	public boolean deleteList(List<Integer> values);
	
	/**
	 * 根据ID查询
	 * @param blockId 区块编号
	 * @return 返回查询结果
	 */
	public Block queryByKey(Integer blockId);
	
	/**
	 * 根据条件查询
	 * @param example 查询条件
	 * @return 返回查询结果
	 */
	public List<Block> queryByExample(BlockExample example);
}
