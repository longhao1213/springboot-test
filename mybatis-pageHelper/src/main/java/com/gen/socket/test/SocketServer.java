package com.gen.socket.test;


import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 龙浩 on 2018/7/11.
 */
public class SocketServer {
    public static void main(String[] args) throws Exception {
        // 监听制定的端口
        ServerSocket server = new ServerSocket(55533);

        // 等待
        System.out.println("server将一直等待连接的到来");
        // 阻塞
        Socket socket = server.accept();
        // 当连接建立好了之后,从socket中获取输入流,并建立缓冲区读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len,"UTF-8"));
        }
        System.out.println("获取到的数据:" + sb);
        // 关闭
        inputStream.close();
        socket.close();
        server.close();
    }
}
