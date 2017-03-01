package com.skeye.yagout.biz;

import com.skeye.yagout.util.CommonPage;
import com.skeye.yagout.util.CommonResult;

import java.util.List;

public interface YagoutAccountBiz {
    void queryAccountByPage(CommonPage commonPage);
    
    CommonResult deleteAccountByList( List<Integer> ids);

    CommonResult queryAccountByList(String accountName, String adslAccount, Integer rows);


}
