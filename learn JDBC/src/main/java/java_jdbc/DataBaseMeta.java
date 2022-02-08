package java_jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class DataBaseMeta {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCConnection.getJDBCConnection();
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        System.out.println(databaseMetaData.getDatabaseProductName());
        System.out.println(databaseMetaData.getUserName());
        System.out.println(databaseMetaData.getURL());
    }
}
