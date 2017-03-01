package com.yagout.defense.service;

import com.yagout.defense.biz.bean.SoketBean;
import com.yagout.defense.util.CommonResult;

/**
 * Created by Skeyedu on 2017/2/17.
 */
public interface SokectSendService {
    /**
     * 统一发送接口
     * @param soketBean
     * @return
     */
    public CommonResult sendData(SoketBean soketBean);
    }
