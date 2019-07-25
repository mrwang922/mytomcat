package com.wdl.v2;

/**
 * @Author: wdl
 * @Description:
 * @Data: Created in 2019/7/25
 * @Modified By:
 */
public class StaticResourceProcessor {

    public void process(Request request, Response response) {
        response.sendStaticResource();
    }
}
