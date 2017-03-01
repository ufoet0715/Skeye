package com.yagout.defense.service.impl;


import com.yagout.defense.dal.dao.DictionaryDao;
import com.yagout.defense.dal.model.Dictionary;
import com.yagout.defense.dal.model.DictionaryExample;
import com.yagout.defense.dal.model.DictionaryExample.Criteria;
import com.yagout.defense.dal.model.DictionaryWithChildren;
import com.yagout.defense.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Skeyedu on 2016/12/15.
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired private DictionaryDao dictionaryDao;
    @Override
    public boolean addDictionary(Dictionary dictionary) {
        return dictionaryDao.addDictionary(dictionary);
    }

    @Override
    public boolean editDictionary(Dictionary dictionary) {
        return dictionaryDao.editDictionary(dictionary);
    }

    @Override
    public List<Dictionary> queryDictionaryByPage(Map<String, Object> map) {
        return dictionaryDao.queryDictionaryByPage(map);
    }

    @Override
    public List<Dictionary> queryDictionaryByParentId(Integer parentId) {
        DictionaryExample example=new DictionaryExample();
        example.createCriteria().andParentKeyEqualTo(parentId);
        return dictionaryDao.queryDictionary(example);
    }

    @Override
    public Dictionary queryDictionaryById(Integer id) {
        DictionaryExample example=new DictionaryExample();
        example.createCriteria().andDictionaryKeyEqualTo(id);
        return dictionaryDao.queryDictionary(example).get(0);
    }

    @Override
    public List<Dictionary> queryAllDictionary() {
        DictionaryExample example=new DictionaryExample();
        return dictionaryDao.queryDictionary(example);
    }

    @Override
    public List<Dictionary> queryDictionaryByIds(List<Integer> ids) {
        DictionaryExample example=new DictionaryExample();
        example.createCriteria().andDictionaryKeyIn(ids);
        return dictionaryDao.queryDictionary(example);
    }

    @Override
    public List<DictionaryWithChildren> queryDictionaryWithChildren(Map<String, Object> map) {
        return dictionaryDao.queryDictionaryWithChildren(map);
    }

    @Override
    public boolean deleteDictionary( Integer ids) {
        return dictionaryDao.deleteDictionary(ids);
    }

	@Override
	public List<Dictionary> queryDictionaryInIds(List<Integer> ids) {
        DictionaryExample example=new DictionaryExample();
        Criteria criteria = example.createCriteria();
        criteria.andDictionaryKeyIn(ids);
		return this.dictionaryDao.queryDictionary(example);
	}
}
