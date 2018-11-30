package com.gen.socket.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by 龙浩 on 2018/7/11.
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        // 要连接服务器的ip和端口号
        String host = "127.0.0.1";
        int port = 55533;
        // 与服务器建立连接
        Socket socket = new Socket(host, port);
        // 建立连接后获取输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "我来了,socket编程";
        // 发送数据
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        // 关闭
        outputStream.close();
        socket.close();
    }
}
