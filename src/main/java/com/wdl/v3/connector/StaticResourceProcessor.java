package com.wdl.v3.connector;

import com.wdl.v2.Request;
import com.wdl.v2.Response;

/**
 * @Author: wdl
 * @Description:
 * @Data: Created in 2019/7/25
 * @Modified By:
 */
public class StaticResourceProcessor {

    public void process(HttpRequest request, HttpResponse response) {
        response.sendStaticResource();
    }
}
