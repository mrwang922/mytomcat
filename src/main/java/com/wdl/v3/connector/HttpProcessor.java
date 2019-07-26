package com.wdl.v3.connector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/**
 * @Author: wdl
 * @Description:
 * @Data: Created in 2019/7/26
 * @Modified By:
 */
public class HttpProcessor {

    private HttpConnector connector;
    private HttpRequest request;
    private HttpResponse response;

    public HttpProcessor(HttpConnector connector) {
        this.connector = connector;
    }

    public void process(Socket socket) {
        SocketInputStream input = null;
        OutputStream output = null;

        try {
            input = new SocketInputStream(socket.getInputStream(), 2048);
            output = socket.getOutputStream();

            request = new HttpRequest(input);

            response = new HttpResponse(output);
            response.setRequest(request);
            response.setHeader("Server", "mytomcat servlet Container");

            parseRequest(input, output);
            parseHeaders(input);

            if (request.getRequestURI().startsWith("/servlet/")) {
                // 处理servlet
                ServletProcessor processor = new ServletProcessor();
                processor.process(request, response);
            } else {
                // 处理静态资源
                StaticResourceProcessor processor = new StaticResourceProcessor();
                processor.process(request, response);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void parseHeaders(InputStream input) {
    }

    private void parseRequest(InputStream input, OutputStream output) {

    }
}
