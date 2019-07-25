package com.wdl.v2;

import java.io.File;

/**
 * @Author: wdl
 * @Description:
 * @Data: Created in 2019/7/25
 * @Modified By:
 */
public class Constants {

    /**
     * D:\workspace\ideaWorkspace\mytomcat
     */
    public static final String WEB_BOOT = System.getProperty("user.dir");

    public static final String WEB_BOOT_CLASS_PATH = System.getProperty("user.dir") + "/target/classes";

    public static final String PACKAGE_NAME = "com.wdl.v2.";

    /**
     * D:\workspace\ideaWorkspace\mytomcat\pic
     */
    public static final String WEB_BOOT_STATIC_RESOURCE = WEB_BOOT + File.separator + "pic";

    public static void main(String[] args) {
        System.out.println(WEB_BOOT);
    }
}
