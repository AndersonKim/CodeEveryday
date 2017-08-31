package com.Util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * sample of JDBC util for mysql
 */
public class JDBCUtil {
    static Properties propertie = null;

    static {
        propertie = new Properties();
        try {
            propertie.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getMySQLConn() {
        try {
            Class.forName(propertie.getProperty("mysqlDriver"));
            return DriverManager.getConnection(propertie.getProperty("mysqlURL"),
                    propertie.getProperty("mysqlUser"), propertie.getProperty("mysqlPwd"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConn(ResultSet rs, Statement st, Connection conn) {

        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (st != null)
                st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}