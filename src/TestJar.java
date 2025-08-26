import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJar {

    private static final String URL = "jdbc:mysql://localhost:3306/practie_db";
    private static final String USER = "root";
    private static final String PASSWORD = "@Onepieceis3eal";

    // Method to establish and return connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
