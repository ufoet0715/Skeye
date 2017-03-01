package com.yagout.defense.service;


import com.yagout.defense.dal.model.Dictionary;
import com.yagout.defense.dal.model.DictionaryWithChildren;

import java.util.List;
import java.util.Map;

public interface DictionaryService {

    public boolean addDictionary(Dictionary dictionary);

    public boolean editDictionary(Dictionary dictionary);

    public List<Dictionary> queryDictionaryByPage(Map<String, Object> map);

    public List<Dictionary> queryDictionaryByParentId(Integer parentId);

    public Dictionary queryDictionaryById(Integer id);

    public List<Dictionary> queryAllDictionary();

    public List<Dictionary> queryDictionaryByIds(List<Integer> ids);

    public List<DictionaryWithChildren> queryDictionaryWithChildren(Map<String, Object> map);

    public boolean deleteDictionary(Integer ids);
    
    List<Dictionary> queryDictionaryInIds(List<Integer> ids);
}