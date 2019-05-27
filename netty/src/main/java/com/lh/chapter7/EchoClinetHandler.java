package com.lh.chapter7;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: EchoClinetHandler.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2019/05/15 16:08
 */
public class EchoClinetHandler extends ChannelInboundHandlerAdapter {
    private final static Logger logger = LoggerFactory.getLogger(EchoClinetHandler.class);

    /**
     * 使用换行符做切割
     * @param ctx
     * @throws Exception
     */
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ByteBuf message = null;
//        byte[] request = ("test message" + System.getProperty("line.separator")).getBytes();
//        for (int i = 0; i < 100; i++) {
//            message = Unpooled.buffer(request.length);
//            message.writeBytes(request);
//            ctx.writeAndFlush(message);
//
//        }
//    }


    /**
     * 使用自定义符号做切割符
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String message = "* Be aware that messages are not released after the {@link #channelRead(ChannelHandlerContext, Object)}&_" +
                " * method returns automatically. If you are looking for a {@link ChannelInboundHandler} implementation that&_" +
                " * releases the received messages automatically, please see {@link SimpleChannelInboundHandler}.&_";
        ByteBuf request = Unpooled.buffer(message.getBytes().length);
        request.writeBytes(message.getBytes());
        ctx.writeAndFlush(request);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}