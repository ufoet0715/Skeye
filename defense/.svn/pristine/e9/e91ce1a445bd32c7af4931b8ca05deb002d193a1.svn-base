package com.yagout.defense.biz.impl;

import com.yagout.defense.biz.SokectReciveBiz;
import com.yagout.defense.biz.bean.SoketBean;
import com.yagout.defense.redis.RedisCache;
import com.yagout.defense.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SokectReciveBizImpl implements SokectReciveBiz {
    @Autowired
    private RedisCache<String, Object> redisCache;
    @Override
    public CommonResult reciveData(SoketBean soketBean) {
       switch (soketBean.getSoketEnum()){
           case DEVICE_STATE_CHANGE:
            return   updateDeviceMonitor();
           case WARNING_NOTICE:
               return    getAlarm();
       }
        return new  CommonResult();
    }

    /**
     * 接收到警告通知
     * @return
     */

    private CommonResult updateDeviceMonitor() {
        CommonResult result=new CommonResult();
        try{
            redisCache.remove(DeviceMonitorBizImpl.DEVICELIST);
            result.setIsSuccess(true);
        }catch (Exception e){

        }
        return result;
    }
    /**
     * 接收到警告通知
     * @return
     */

    private CommonResult getAlarm() {
        CommonResult result=new CommonResult();
        try{
            redisCache.put(AlarmRecordBizImpl.ALARMRECORDSTATE,true,50000);
            result.setIsSuccess(true);
        }catch (Exception e){

        }
        return result;
    }
}
