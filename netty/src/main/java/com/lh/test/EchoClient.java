package com.lh.test;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: EchoClient.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2019/04/22 09:31
 */
public class EchoClient {
    private String host;
    private int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            // 创建启动类
            Bootstrap bootstrap = new Bootstrap();
            // 配置启动
            bootstrap.group(group)
                    // 配置通道类型
                    .channel(NioSocketChannel.class)
                    // 配置地址和端口
                    .remoteAddress(host,port)

                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            // 连接到服务端，connect是异步连接，在调用同步等待sync，等待连接成功
            ChannelFuture channelFuture = bootstrap.connect().sync();
            // 阻塞直到客户端通道关闭
            channelFuture.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoClient("127.0.0.1", 8080).start();
    }
}