package com.lh.test;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: EchoServerHandler.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2019/04/22 09:11
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * 读取服务端接收到的数据
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf data = (ByteBuf) msg;
        System.out.println("服务端收到来自客户端的数据 : " + data.toString(CharsetUtil.UTF_8));
        // 把数据直接返回给客户端
        ctx.writeAndFlush(data);

        // 调用下一个handler的 channelRead方法 其他的方法一样,如:ctx.fireChannelReadComplete("");
//        ctx.fireChannelRead("");
    }

    /**
     * 服务端成功接收数据后
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("服务端成功接收数据");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("服务端异常");
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel声明周期之 -- 注册");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel声明周期之 -- 未注册");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel声明周期之 -- 运行中");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel声明周期之 -- 不在运行中");
    }
}