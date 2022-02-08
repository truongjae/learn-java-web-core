package java_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchJDBC {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCConnection.getJDBCConnection();
//        String sql1 = "insert into person values(3,'D')";
//        String sql2 = "insert into person values(4,'E')";
//        String sql3 = "insert into person values(5,'F')";
//
//        Statement statement = connection.createStatement();
//        statement.addBatch(sql1);
//        statement.addBatch(sql2);
//        statement.addBatch(sql3);
//        statement.executeBatch();
        String sql4 = "insert into person values(?,?)";
        PreparedStatement ps = connection.prepareStatement(sql4);
        ps.setInt(1,6);
        ps.setString(2,"G");
        ps.addBatch();
        ps.setInt(1,7);
        ps.setString(2,"H");
        ps.addBatch();
        ps.setInt(1,8);
        ps.setString(2,"K");
        ps.addBatch();
        ps.executeBatch();



    }
}
