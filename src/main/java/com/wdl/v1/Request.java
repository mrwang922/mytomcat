package com.wdl.v1;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @Author: wdl
 * @Description:
 * @Data: Created in 2019/7/24
 * @Modified By:
 */
public class Request {

    private InputStream input;
    private final String CHARSET = "GBK";
    private String uri;

    public Request(InputStream input) {
        this.input = input;
    }


    public void parse() {
        byte[] bytes = new byte[2048];
        StringBuffer sb = new StringBuffer(2048);
        try {
//            while ((len = input.read(bytes)) != -1) {
//                sb.append(new String(bytes, 0, len, CHARSET));
//            }
            input.read(bytes);
            sb.append(new String(bytes, 0, bytes.length, CHARSET));
            System.out.println("HttpRequest-parse:" + sb.toString());

            uri = parseUri(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String parseUri(String str) {
        int index1, index2;
        index1 = str.indexOf(' ');
        if (index1 != -1) {
            index2 = str.indexOf(' ', index1 + 1);
            if (index2 > index1) {
                return str.substring(++index1, index2);
            }
        }
        return null;
    }

    public String getUri() {
        return uri;
    }
}
