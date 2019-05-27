package com.milionServer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Socket;
import java.util.concurrent.ExecutionException;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: NettyClient.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2019/05/27 15:20
 */
public class NettyClient {
    public static String host = "127.0.0.1";

    public static void main(String[] args) {
        new NettyClient().run(Config.startPort, Config.endPort);
    }

    private void run(int startPort, int endPort) {
        EventLoopGroup loopGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(loopGroup)
                .channel(SocketChannel.class)
                .option(ChannelOption.SO_REUSEADDR, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {

                    }
                });
        int index = 0;
        int finalPort;
        while (true) {
            finalPort = startPort + index;
            try {
                bootstrap.bind(host, finalPort).addListener((ChannelFutureListener) future -> {
                    if (!future.isSuccess()) {
                        System.out.println("创建连接失败");
                    }
                }).get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ++index;
            if (index == (endPort - startPort)) {
                index = 0;
            }

        }
    }
}