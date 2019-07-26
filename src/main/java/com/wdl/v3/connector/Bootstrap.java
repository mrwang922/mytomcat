package com.wdl.v3.connector;

/**
 * @Author: wdl
 * @Description:
 * @Data: Created in 2019/7/26
 * @Modified By:
 */
public class Bootstrap {

    public static void main(String[] args) {
        HttpConnector connector = new HttpConnector();
        connector.start();
    }

}
