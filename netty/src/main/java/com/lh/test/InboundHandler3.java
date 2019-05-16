package com.lh.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: InboundHandler2.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2019/05/06 15:42
 */
public class InboundHandler3 extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf data = (ByteBuf) msg;
        System.out.println("InboundHandler3:" + data.toString(CharsetUtil.UTF_8));
        ctx.writeAndFlush(Unpooled.copiedBuffer("InboundHandler3:" + data.toString(CharsetUtil.UTF_8), CharsetUtil.UTF_8));
    }
}