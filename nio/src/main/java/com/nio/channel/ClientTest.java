package com.nio.channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: ClientTest.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2019/04/17 16:42
 */
public class ClientTest {
    public static void main(String[] args) throws IOException {
        // 创建socket通道
        SocketChannel socketChannel = SocketChannel.open();
        // 绑定连接
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 5000));
        // 创建写入缓冲区
        ByteBuffer readBuffer = ByteBuffer.allocate(32);
        // 创建读取缓冲区
        ByteBuffer writeBuffer = ByteBuffer.allocate(32);
        // 写入数据
        writeBuffer.put("hello".getBytes());
        // 反转缓冲区
        writeBuffer.flip();
        while (true) {
            // 把指针归于0
            writeBuffer.rewind();
            // 把缓冲区的数据写入通道
            socketChannel.write(writeBuffer);
            // 清空缓冲区
            readBuffer.clear();
            // 把通道的数据读取到缓冲区
            socketChannel.read(readBuffer);
        }
    }
}