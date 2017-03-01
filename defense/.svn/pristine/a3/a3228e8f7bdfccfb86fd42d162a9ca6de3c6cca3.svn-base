package com.yagout.defense.dal.dao;


import java.util.List;
import java.util.Map;

import com.yagout.defense.dal.model.Dictionary;
import com.yagout.defense.dal.model.DictionaryExample;
import com.yagout.defense.dal.model.DictionaryWithChildren;

public interface DictionaryDao {

	public boolean addDictionary(Dictionary dictionary);

	public boolean editDictionary(Dictionary dictionary);

	public List<Dictionary> queryDictionaryByPage(Map<String, Object> map);

	public List<Dictionary> queryDictionary(DictionaryExample example);

	public List<DictionaryWithChildren> queryDictionaryWithChildren(Map<String, Object> map);

	public boolean deleteDictionary(Integer id) ;


}