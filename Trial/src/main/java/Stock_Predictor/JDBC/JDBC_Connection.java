package Stock_Predictor.JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC_Connection {

    public static Connection SQLConnection() {
        Properties props = new Properties();

        // Load credentials from db.properties (excluded from git)
        try (InputStream input = JDBC_Connection.class
                .getClassLoader()
                .getResourceAsStream("db.properties")) {

            if (input == null) {
                System.err.println(" db.properties not found in resources.");
                System.err.println(" Copy db.properties.example -> db.properties and fill in your credentials.");
                return null;
            }

            props.load(input);

        } catch (IOException e) {
            System.err.println(" Failed to load db.properties: " + e.getMessage());
            return null;
        }

        String url      = props.getProperty("db.url");
        String user     = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println(" Database connection failed: " + e.getMessage());
        }

        return connection;
    }

}
