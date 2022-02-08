package java_jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTransaction {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCConnection.getJDBCConnection();
        Statement statement1 = connection.createStatement();
        connection.setAutoCommit(false);
        String sql1 = "insert into persion(id,name) values(2,'A')";
        String sql2 = "delete fron person whrer id = 1";
        statement1.executeUpdate(sql1);
        connection.commit();

    }
}
