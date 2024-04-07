package org.example.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnector {
    private Connection connection = null;

    private DbConnector() {
        try {
            connection = DriverManager
                    .getConnection("",
                            "", "");
        } catch (Exception e) {
            System.out.println("Ошибка соединения с базой данных");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DbConnector instance = null;

    public static DbConnector getInstance() {
        if (instance == null) {
            instance = new DbConnector();
        }
        return instance;
    }
}
