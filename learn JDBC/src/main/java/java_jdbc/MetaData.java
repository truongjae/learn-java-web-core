package java_jdbc;

import java.sql.*;

public class MetaData {
    public static void main(String[] args) {
        Connection connection = JDBCConnection.getJDBCConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select * from person";
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            System.out.println(metaData.getColumnCount());
            System.out.println(metaData.getColumnName(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
