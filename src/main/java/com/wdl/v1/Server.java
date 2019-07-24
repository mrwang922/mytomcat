package com.wdl.v1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wdl
 * @Description:
 * @Data: Created in 2019/7/23
 * @Modified By:
 */
public class Server {

    private List list;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Socket socket = null;
        InputStream input = null;
        OutputStream output = null;
        try {
            socket = serverSocket.accept();
            input = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuffer sb = new StringBuffer();
            while ((len = input.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len,"gbk"));
            }
            System.out.println(sb.toString());
            input.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
