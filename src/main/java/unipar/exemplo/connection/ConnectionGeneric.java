package unipar.exemplo.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    public Connection conn;

    private final String URL = "jdbc:postgresql://localhost:5432/";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "admin";
    private final String DBNAME = "postgres";

    private String urlConnection = "";
    public  Connection(){

        this.urlConnection = URL + DBNAME;

    }

    public void getConnection() throws SQLException {

        Connection conn =
                DriverManager.getConnection(this.urlConnection, USERNAME, PASSWORD);


    }

}
