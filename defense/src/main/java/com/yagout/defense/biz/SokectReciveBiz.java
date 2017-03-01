package com.yagout.defense.biz;

import com.yagout.defense.biz.bean.SoketBean;
import com.yagout.defense.util.CommonResult;

/**
 * Created by Skeyedu on 2017/2/9.
 */
public interface SokectReciveBiz {

    /**
     * 统一接收接口
     * @param soketBean
     * @return
     */
    public CommonResult reciveData(SoketBean soketBean);
}
