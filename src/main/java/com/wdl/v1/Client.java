package com.wdl.v1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: wdl
 * @Description:
 * @Data: Created in 2019/7/23
 * @Modified By:
 */
public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 8080);
            OutputStream output = socket.getOutputStream();
            output.write("测试数据".getBytes("utf-8"));
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
