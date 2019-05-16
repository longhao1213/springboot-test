package com.lh.test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: EchoServer.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2019/04/22 08:59
 */
public class EchoServer {
    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        // 创建两个线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            // 创建启动服务
            ServerBootstrap bootstrap = new ServerBootstrap();
            // 配置启动
            bootstrap.group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)

                    .childHandler(new MyChannelInitChannel());
            System.out.println("客户端服务启动,端口:" + port);
            // 绑定端口,同步等待
            ChannelFuture channelFuture = bootstrap.bind(port).sync();
            // 监听客户端断开连接
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoServer(8080).start();
    }

    
    public static class MyChannelInitChannel extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
//            socketChannel.pipeline().addLast(new EchoServerHandler());
            ChannelPipeline pipeline = socketChannel.pipeline();

            pipeline.addLast(new InboundHandler1());
            pipeline.addLast(new InboundHandler2());
            pipeline.addLast(new InboundHandler3());
            pipeline.addLast(new OutboundHandler1());
            pipeline.addLast(new OutboundHandler2());

        }
    }

}