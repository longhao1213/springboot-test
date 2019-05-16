package com.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: ServerTest.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2019/04/11 13:43
 */
public class ServerTest {

    public static void main(String[] args) throws IOException {
        // 创建通道
        ServerSocketChannel ssc = ServerSocketChannel.open();
        // 绑定端口
        ssc.socket().bind(new InetSocketAddress("127.0.0.1", 5000));
        // 设置通道为非阻塞模式
        ssc.configureBlocking(false);
        // 创建选择器
        Selector selector = Selector.open();
        // 把通道注册到选择器中
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        // 创建读取缓冲器,并设定缓冲区容量
        ByteBuffer readBuff = ByteBuffer.allocate(128);
        // 创建写入缓冲区,并设定缓冲区容量
        ByteBuffer writerBuff = ByteBuffer.allocate(128);
        // 写入数据
        writerBuff.put("received".getBytes());
        // 反转缓冲区
        writerBuff.flip();

        while (true) {
            // 选择一组值
            selector.select();
            // 返回选中值的键值
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {
                    // 此键能够接受新的套接字
                    // 接受此通道套接字的连接
                    SocketChannel socketChannel = ssc.accept();
                    // 调整通道为非阻塞模式
                    socketChannel.configureBlocking(false);
                    // 注册选择器到通道中,
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    // 此键已经准备好读取
                    // 返回此键的通道
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    // 清空此缓存区
                    readBuff.clear();
                    // 将通道中的数据读取到缓冲区
                    socketChannel.read(readBuff);
                    // 反转缓冲区
                    readBuff.flip();
                    System.out.println(new String(readBuff.array()));
                    // 将此键的 interest 集合设置为给定值。
                    key.interestOps(SelectionKey.OP_WRITE);
                } else if (key.isWritable()) {
                    // 此键已经准备好写入
                    // 重绕此缓冲区  重新绑定??
                    writerBuff.rewind();
                    // 返回此键的通道
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    // 把缓冲区的数据读取到通道
                    socketChannel.write(writerBuff);
                    key.interestOps(SelectionKey.OP_READ);
                }
            }
        }

    }
}