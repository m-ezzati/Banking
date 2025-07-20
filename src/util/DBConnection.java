package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/banking";
        String userName = "postgres";
        String password = "123";
        return DriverManager.getConnection(url, userName, password);
    }

}
