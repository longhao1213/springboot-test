package com.gen.socket.test1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 龙浩 on 2018/7/11.
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        // 监听制定的端口
        ServerSocket server = new ServerSocket(55533);
        // server 建立后将会一直等待连接到到来
        System.out.println("将会一直等待连接的到来");
        // 阻塞
        Socket socket = server.accept();
        // 从socket中获取数据
        InputStream inputStream = socket.getInputStream();
        StringBuilder sb = new StringBuilder();
        int len;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len, "utf-8"));
        }
        System.out.println("获取到数据是:" + sb);

        // 给客户端返回数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到你的消息了,socket编程".getBytes("utf-8"));

        inputStream.close();
        outputStream.close();
        socket.close();
        server.close();
    }
}
