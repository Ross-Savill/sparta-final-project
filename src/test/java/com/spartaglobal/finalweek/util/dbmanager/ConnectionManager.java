package com.spartaglobal.finalweek.util.dbmanager;

import com.spartaglobal.finalweek.util.PropertiesLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection connection;

    public static Connection openConnection() {
        String url = PropertiesLoader.getProperties().getProperty("DBURL");
        String username = PropertiesLoader.getProperties().getProperty("DBUserName");
        String password = PropertiesLoader.getProperties().getProperty("DBPassWord");

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}