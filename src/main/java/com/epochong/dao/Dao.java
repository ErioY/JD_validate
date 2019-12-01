package com.epochong.dao;


import com.epochong.utils.JdbcUtils;
import com.epochong.utils.Util;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author epochong
 * @date 2019/8/3 9:52
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe 封装基础操作，数据源，获取连接，关闭资源
 */
public class Dao {


    /**
     * 获取连接
     * @return
     */
    protected Connection getConnection() {
        return JdbcUtils.getConnection();
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
