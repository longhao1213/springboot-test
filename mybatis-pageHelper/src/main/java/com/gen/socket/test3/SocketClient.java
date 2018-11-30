package com.gen.socket.test3;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by 龙浩 on 2018/7/12.
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 55533);
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好,socket编程";
        // 首先需要计算得知消息的长度
        byte[] sendBytes = message.getBytes("utf-8");
        // 然后将消息的长度优先发送出去
        outputStream.write(sendBytes.length >> 8);
        outputStream.write(sendBytes.length);
        // 然后在再次将消息发送出去
        outputStream.write(message.getBytes("utf-8"));
        outputStream.flush();
        // 此处重复发送一次
        message = "第二条消息";
        sendBytes = message.getBytes("utf-8");
        outputStream.write(sendBytes.length >> 8);
        outputStream.write(sendBytes.length);
        outputStream.write(message.getBytes("utf-8"));
        outputStream.flush();
        // 此处重复发送一次
        message = "第三条消息";
        sendBytes = message.getBytes("utf-8");
        outputStream.write(sendBytes.length >> 8);
        outputStream.write(sendBytes.length);
        outputStream.write(message.getBytes("utf-8"));

        outputStream.close();
        socket.close();
    }
}
