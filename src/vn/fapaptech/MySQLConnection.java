package vn.fapaptech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {
    public static Connection getMyConnection() throws SQLException {
        String hostName = "localhost";//127.0.0.1
        String dbName = "java2practice";
        String userName = "root";
        String password = "";
        //Chuoi ket noi database
        //"jdbc:mysql://localhost:3306?myprojectjava,userName, password
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        Connection connection =
                DriverManager.getConnection(connectionURL,userName,password);
        return connection;
    }

    public static void createEmployeeTable() throws SQLException{
        Connection connection = getMyConnection();
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE IF EXISTS employee");
        statement.execute("CREATE TABLE employee(id varchar (10) primary key ," +
                "name varchar (20)," +
                "salary varchar (20))");
    }
}
