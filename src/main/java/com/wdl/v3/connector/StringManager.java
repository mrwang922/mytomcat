package com.wdl.v3.connector;

import java.util.Hashtable;

/**
 * @Author: wdl
 * @Description:
 * @Data: Created in 2019/7/25
 * @Modified By:
 */
public class StringManager {

    private StringManager() {}

    private static Hashtable managers = new Hashtable();

    public synchronized static StringManager getManager(String packageName) {
        StringManager mgr = (StringManager) managers.get(packageName);
        if (null != mgr) {
            mgr = new StringManager();
            managers.put(packageName, mgr);
        }
        return mgr;
    }

    public String getString(String key) {
        if (key == null) {
            String msg = "key is null";

            throw new NullPointerException(msg);
        }

        String str = null;

//        try {
//            str = bundle.getString(key);
//        } catch (MissingResourceException mre) {
//            str = "Cannot find message associated with key '" + key + "'";
//        }

        return str;
    }
}
