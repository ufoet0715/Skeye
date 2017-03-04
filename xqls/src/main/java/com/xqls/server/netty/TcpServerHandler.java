package com.xqls.server.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TcpServerHandler extends SimpleChannelInboundHandler<Object> {
    private static final Logger LOG = LoggerFactory
            .getLogger(TcpServerHandler.class);
    @Override  
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        LOG.info("SERVER接收到消息:" + msg);
        ctx.channel().writeAndFlush("server accepted msg:" + msg);  
    }  
  
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOG.warn("exceptionCaught!", cause);
        ctx.close();  
    }  
} 