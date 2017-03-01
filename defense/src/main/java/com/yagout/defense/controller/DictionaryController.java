package com.yagout.defense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.yagout.defense.biz.DictionaryBiz;
import com.yagout.defense.biz.bean.DictionaryBean;

@Controller
@RequestMapping(value = "/dictionary")
public class DictionaryController {

    @RequestMapping(value = "/index")
    public ModelAndView list() {
        ModelAndView view = new ModelAndView("dictionary/dictionaryIndex");
        return view;
    }

    @Autowired
    private DictionaryBiz dictionaryBiz;
    @RequestMapping(value = "/treeData")
    @ResponseBody
    public String treeData() {
        return JSONObject.toJSONString(dictionaryBiz.queryAllDictionary());
    }
    @RequestMapping(value = "/save")
    public @ResponseBody String save( DictionaryBean dictionaryBean) {
        return JSONObject.toJSONString(dictionaryBiz.editDictionary(dictionaryBean));
    }

    @RequestMapping(value = "/delete")
    public @ResponseBody String delete(@RequestParam("id") Integer id) {
        return JSONObject.toJSONString(dictionaryBiz.deleteDictionary(id));
    }
}