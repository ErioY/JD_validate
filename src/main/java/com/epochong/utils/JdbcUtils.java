package com.epochong.utils;

import java.sql.*;
import java.util.Properties;

/**
 * @author wangchong
 * @date 2019/5/23 7:54
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe 封装JDBC操作的公共方法
 */
public class JdbcUtils {
    //可以把几个字符串定义成常量：用户名，密码，URL，驱动类
    private static  String driverName;
    private static  String url;
    private static  String userName;
    private static  String password;
    /**
     * 注册驱动
     */
    static {
        Properties properties = Util.loadProperties("datasource.properties");
        driverName = properties.getProperty("driver");
        url = properties.getProperty("url");
        userName = properties.getProperty("username");
        password = properties.getProperty("password");
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.err.println("加载数据库出错");
            e.printStackTrace();
        }
    }
    /**
     * 得到数据库的连接
     */
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            System.err.println("获取数据库连接出错");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭所有打开的资源,数据库只能一个用户使用
     * 数据库更新没有查询
     * @param conn
     * @param stmt
     */
    public static void close(Connection conn, Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭所有打开的资源
     * @param conn
     * @param stmt
     * @param rs
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(conn, stmt);
    }
}
