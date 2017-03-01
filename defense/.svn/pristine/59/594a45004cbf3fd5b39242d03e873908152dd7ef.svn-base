package com.yagout.defense.service.impl;

import com.yagout.defense.biz.bean.SoketBean;
import com.yagout.defense.netty.NettyTCPServer;
import com.yagout.defense.service.SokectSendService;
import com.yagout.defense.util.CommonResult;
import io.netty.channel.Channel;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class SokectSendServiceImpl implements SokectSendService {
    @Override
    public CommonResult sendData(SoketBean soketBean) {
        CommonResult result=new  CommonResult();
        Map<String, Channel> map=
                NettyTCPServer.getChannelMap();
        if(map!=null&&map.size()>0){
            for (Channel channel:map.values()){
                channel.write("aaaaa"); //// TODO: 2017/2/15    soketBean插入
                channel.flush();
            }
        }
        result.setIsSuccess(true);

        return result;
    }
}
