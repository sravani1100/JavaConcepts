package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url = "jdbc:mysql://localhost:3306/Employee";
    private static final String user = "employee";
    private static final String password = "java@123";

    private DBConnection(){}

    public static Connection connectDB() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
