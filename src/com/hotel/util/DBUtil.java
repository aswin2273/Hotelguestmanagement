package com.hotel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "hotel";
    private static final String PASSWORD = "hotel";

    public static Connection getDBConnection() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
