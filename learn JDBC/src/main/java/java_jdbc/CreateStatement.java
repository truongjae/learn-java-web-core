package java_jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStatement {
    public static void createTable(){
        Connection connection = JDBCConnection.getJDBCConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            final String sql = "create table person(id INT,name varchar(50))";
            int rs = statement.executeUpdate(sql);
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void dropTable(){
        Connection connection = JDBCConnection.getJDBCConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            final String sql = "drop table person";
            int rs = statement.executeUpdate(sql);
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createTable();
//        dropTable();
    }
}
