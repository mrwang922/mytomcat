package com.wdl.v3.connector;

import java.io.InputStream; /**
 * @Author: wdl
 * @Description:
 * @Data: Created in 2019/7/26
 * @Modified By:
 */
public class HttpRequest {
    private InputStream input;
    private final String CHARSET = "GBK";
    private String uri;

    public HttpRequest(InputStream input) {
    }

    public String getRequestURI() {
        return null;
    }
}
