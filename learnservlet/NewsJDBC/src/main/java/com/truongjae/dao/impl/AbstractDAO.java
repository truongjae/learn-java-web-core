package com.truongjae.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.truongjae.dao.GenericDAO;
import com.truongjae.mapper.RowMapper;
import com.truongjae.model.CategoryModel;

public class AbstractDAO<T> implements GenericDAO<T>{
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/newsservlet";
			String username = "root";
			String password = "1234";
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = getConnection();
		if(connection!=null) {
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				//set parameter
				setParameter(ps,parameters);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					T t = rowMapper.mapRow(rs);
					results.add(t);
				}
				return results;
			} catch (SQLException e) {
				return null;
			}
			finally {
				if(connection!=null)
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		return null;
	}

	private void setParameter(PreparedStatement ps, Object...parameters) {
		try {
			for(int i=0;i<parameters.length;i++) {
				Object parameter= parameters[i];
				int index = i+1;
				if(parameter instanceof Long) {
					ps.setLong(index, (Long) parameter);
				}
				else if(parameter instanceof String) {
					ps.setString(index,(String) parameter);
				}
				else if(parameter instanceof Integer) {
					ps.setInt(index, (Integer) parameter);
				}
				else if(parameter instanceof Timestamp) {
					ps.setTimestamp(index, (Timestamp) parameter);
				}
				else if(parameter == null) {
					ps.setNull(index, Types.NULL);
				}
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = getConnection();
		PreparedStatement ps=null;
		try {
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			setParameter(ps, parameters);
			ps.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		finally {
			if(connection!= null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection connection = getConnection();
		Long id = null;
		PreparedStatement ps=null;
		try {
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			setParameter(ps, parameters);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				id= rs.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					return null;
				}
			}
			return null;
		}
		finally {
			if(connection!= null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
