package com.milionServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: NettyServer.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2019/05/27 14:46
 */
public class NettyServer {
    public static void main(String[] args) {
        new NettyServer().run(Config.startPort,Config.endPort);
    }

    private void run(int startPort, int endPort) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childOption(ChannelOption.SO_REUSEADDR, true)
                .childHandler(new TcpCountHandler());
        for (; startPort < endPort; startPort++) {
            int port = startPort;
            serverBootstrap.bind(port).addListener((ChannelFutureListener) future -> {
                System.out.println("服务端成功绑定端口号 port:" + port);
            });
        }
    }
}