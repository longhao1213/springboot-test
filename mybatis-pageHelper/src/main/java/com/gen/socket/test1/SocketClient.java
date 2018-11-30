package com.gen.socket.test1;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by 龙浩 on 2018/7/11.
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        // 与服务器建立连接
        Socket socket = new Socket("127.0.0.1", 55533);
        // 建立连接发送数据
        String message = "你好,socket编程";
        socket.getOutputStream().write(message.getBytes("utf-8"));
        // 发送完成,关闭输出流,等待接受数据
        socket.shutdownOutput();

        // 接受数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len ;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len, "utf-8"));
        }
        System.out.println("获取到的返回消息:" + sb);

        inputStream.close();
        socket.close();
    }
}
