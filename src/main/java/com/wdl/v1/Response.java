package com.wdl.v1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: wdl
 * @Description:
 * @Data: Created in 2019/7/24
 * @Modified By:
 */
public class Response {

    private OutputStream output;
    private Request request;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() {
        byte[] bytes = new byte[2048];
        File file = new File(HttpServer.WEB_BOOT, request.getUri());
        FileInputStream fis = null;
        try {
            if (file.exists()) {
                fis = new FileInputStream(file);
                int len;
                while ((len = fis.read(bytes)) != -1) {
                    output.write(bytes, 0, len);
                }

            } else { // 找不到文件
                String errorMsg = "HTTP/1.1 404 File Not Found \r\n Content-Type: test/html\r\n Content-Length: 23\r\n \r\n<h1>File Not Found</h1>";
                output.write(errorMsg.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
