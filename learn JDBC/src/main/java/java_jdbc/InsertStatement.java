package java_jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStatement {
    public static void insertRecords(int id,String name){
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "insert into person(id,name) values("+id+",'"+name+"')";
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateRecords(int id,String name){
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "update person set name = '"+name+"' where id ="+id;
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteRecords(int id){
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "delete from person where id ="+id;
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        insertRecords(3,"C");
//        updateRecords(3,"haha");
        deleteRecords(3);
    }
}
