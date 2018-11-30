package com.gen.socket.test3;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 龙浩 on 2018/7/12.
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(55533);

        Socket socket = server.accept();
        // 读取输入流
        InputStream inputStream = socket.getInputStream();
        byte[] bytes;
        while (true) {
            // 首先读取两个字节表示的长度
            int first = inputStream.read();
            // 如果长度是-1,那么说明已经到流的末尾,socket已经被关闭,
            if (first == -1) {
                break;
            }
            int second = inputStream.read();
            int length = (first << 8) + second;
            bytes = new byte[length];
            inputStream.read(bytes);
            System.out.println("获取到的数据:" + new String(bytes, "utf-8"));
        }
        inputStream.close();
        socket.close();
        server.close();
    }
}
