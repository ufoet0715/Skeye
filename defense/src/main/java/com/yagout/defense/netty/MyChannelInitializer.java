package com.yagout.defense.netty;

import com.yagout.defense.biz.SokectReciveBiz;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Autowired;

// ChannelInitializer是默认的initializer，因此需要继承ChannelInitializer类来实现自己的initializer
public class MyChannelInitializer extends
        ChannelInitializer<SocketChannel> {
    private static final int MAX_IDLE_SECONDS = 60;


    @Autowired
    private SokectReciveBiz sokectCommonRecive;
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        // 添加到pipeline中的handler会被串行处理(PS: 类似工业生产中的流水线)
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("idleStateCheck", new IdleStateHandler(
                MAX_IDLE_SECONDS, MAX_IDLE_SECONDS, MAX_IDLE_SECONDS));//检测心跳

//        // 以("\n")为结尾分割的 解码器
//        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192,
//                Delimiters.lineDelimiter()));
//        // 字符串解码 和 编码
//        pipeline.addLast("decoder", new StringDecoder());
//        pipeline.addLast("encoder", new StringEncoder());

        // 使用addLast来添加自己定义的handler到pipeline中
        pipeline.addLast( new TcpServerHandler(sokectCommonRecive));

    }

}
