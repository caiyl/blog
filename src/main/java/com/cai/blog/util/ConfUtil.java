package com.cai.blog.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * 系统配置
 *
 * @author caiyl
 * @version 1.0
 * @date 2016-10-16 下午2:56:35
 */
public class ConfUtil {

    private static Properties properties;

    static {
        properties = new Properties();
        URL url = ConfUtil.class.getClassLoader().getResource("system.properties");
        File file = new File(url.getFile());
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(file);
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if ((stream != null)) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static String getValue(String key) {
        return properties.getProperty(key);
    }

    public static String getMsgChartset() {
        return properties.getProperty("message.chartset");
    }


    public static String getCorePrefixHost() {
        return properties.getProperty("corePrefix.host");
    }
    public static int getCorePrefixPort() {
        return Integer.parseInt(properties.getProperty("corePrefix.port"));
    }
}
