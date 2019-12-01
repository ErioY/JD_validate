package com.epochong.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author epochong
 * @date 2019/10/21 15:23
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class Util {
    public static boolean isNull(String ... strings) {
        for (int i = 0; i < strings.length; i++) {
            if ("".equals(strings[i]) || null == strings[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据指定的文件名加载配置文件
     * @param fileName 配置文件名
     * @return
     */
    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        // 获取当前配置文件夹下的文件输入流
        InputStream in = Util.class.getClassLoader()
                .getResourceAsStream(fileName);
        // 加载配置文件中的所有内容
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    public static boolean strIsNull(String str) {
        return str == null || str.equals("");
    }
}
