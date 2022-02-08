package java_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectPreparedStatement {
    public static void main(String[] args) {
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * from person where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id =rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id+" "+name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
