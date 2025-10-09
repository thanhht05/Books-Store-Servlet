package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiJDBC {
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=VOLUNTEER;encrypt=false";
    private static final String USER = "sa";
    private static final String PASSWORD = "2005";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
