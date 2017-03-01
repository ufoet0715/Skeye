package com.skeye.yagout.biz;

import com.skeye.yagout.util.CommonPage;
import com.skeye.yagout.util.CommonResult;

import java.util.List;

public interface YagoutDailinfoHandledBiz {
	void queryDailinfoHandledByPage(CommonPage commonPage);
	
	CommonResult deleteDailinfoHandledByList(List<Integer> ids);
	
}
