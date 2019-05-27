package com.lh.chapter7;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: EchoServer.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2019/05/15 15:53
 */
public class EchoServer {
    private final static Logger logger = LoggerFactory.getLogger(EchoServer.class);
    public void start(int port){
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        logger.info("服务端启动");
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
//                            // 换行符解码器 单位 字节 此解码器指在数据在1024个字节内必须出现换行符,否者报错
//                            ch.pipeline().addLast(new LineBasedFrameDecoder(100));

                            // 创建一个切割符
                            ByteBuf byteBuf = Unpooled.copiedBuffer("&_".getBytes());
                            // 自定义字符解码器 切割符为ByteBuf类型的 还有两个参数 stripDelimiter:接收的数据是否去掉切割符 failFast:在指定字节内没有找到对应切割符,是否继续遍历后面的数据寻找
                            ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, byteBuf));

                            // 解码器,将数据转换成String类型
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            ChannelFuture future = bootstrap.bind(port);
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args){
        new EchoServer().start(8080);
    }
}