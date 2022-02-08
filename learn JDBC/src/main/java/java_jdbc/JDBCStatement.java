package java_jdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatement {
    public static void main(String[] args) {
        Connection connection = JDBCConnection.getJDBCConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select * from demo";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id+" "+name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
