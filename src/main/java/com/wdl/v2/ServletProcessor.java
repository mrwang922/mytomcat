package com.wdl.v2;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import javax.servlet.Servlet;

/**
 * @Author: wdl
 * @Description:
 * @Data: Created in 2019/7/25
 * @Modified By:
 */
public class ServletProcessor {

    public void process(Request request, Response response) {
        String uri = request.getUri();
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);

        try {
            // 加在servlet
            URLStreamHandler streamHandler = null;
            URL[] urls = new URL[1];
            urls[0] = new URL(null, (new URL("file", null,Constants.WEB_BOOT_CLASS_PATH + File.separator)).toString(), streamHandler);
            URLClassLoader classLoader = new URLClassLoader(urls);

            Class myClass = classLoader.loadClass(Constants.PACKAGE_NAME + servletName);

            Servlet servlet = (Servlet)myClass.newInstance();
            RequestFacade requestFacade = new RequestFacade(request);
            ResponseFacade responseFacade = new ResponseFacade(response);

            servlet.service(requestFacade, responseFacade);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        URL[] urls = new URL[1];
        URLStreamHandler streamHandler = null;
        String repository = (new URL("file", null,Constants.WEB_BOOT_CLASS_PATH + File.separator)).toString();
        urls[0] = new URL(null, repository, streamHandler);
        URLClassLoader classLoader = new URLClassLoader(urls);

        Class myClass = classLoader.loadClass("com.wdl.v2.PrimitiveServlet");
    }
}
