package com.wdl.v2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author: wdl
 * @Description:
 * @Data: Created in 2019/7/24
 * @Modified By:
 */
public class PrimitiveServlet implements Servlet{

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("PrimitiveServlet-init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("from service");
        PrintWriter printWriter = servletResponse.getWriter();
        printWriter.println("Hello PrimitiveServlet");
        printWriter.print("cehsi shuju ");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("PrimitiveServlet-destroy");
    }
}
