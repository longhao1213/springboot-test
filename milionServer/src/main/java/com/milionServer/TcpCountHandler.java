package com.milionServer;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: TcpCountHandler.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2019/05/27 14:50
 */
// 次注解为了让此handler为全局通用
@ChannelHandler.Sharable
public class TcpCountHandler extends ChannelInboundHandlerAdapter {
    private AtomicInteger atomicInteger = new AtomicInteger();

    public TcpCountHandler() {
        // 打印当前连接总数,定时任务
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            System.out.println("当前连接总数:" + atomicInteger.get());
        }, 0, 3, TimeUnit.SECONDS);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        atomicInteger.incrementAndGet();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        atomicInteger.decrementAndGet();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("TcpCountHandler 发生异常");
        cause.printStackTrace();
    }
}