package lesson5.Assignment2;

import lesson4.Assignment1.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SampleSingleton {
    private static Connection conn = null;
    private static SampleSingleton instance = null;

    private static volatile boolean initialized;

    public static SampleSingleton getInstance() throws SQLException {
        if (!initialized) {
            synchronized (Singleton.class) {
                if (!initialized) {
                    instance = new SampleSingleton();
                    conn = DriverManager.getConnection("127.0.0.1");
                    initialized = true;
                }
            }
        }

        return instance;
    }

    public static Connection getConn() throws SQLException {
        if (!initialized) {
            getInstance();
        }

        return conn;
    }

    private SampleSingleton() {}
}
