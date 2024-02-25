package DAL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

public class DataProvider<T> {
	private static Connection getConnection() {
            
            //mọi người chỉnh sửa thông tin sql của mình ở đây
            String user = "learnspring";
            String password = "123456";
            String url = "jdbc:mysql://localhost:3306/school";
            
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;	
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	private static void setParameters(PreparedStatement statement, String query, Object... parameters) {
		try {
			for(int i = 1; i <= parameters.length; i++) {
				int index = i - 1;
				if(parameters[index] instanceof Integer) {
					statement.setInt(i, (int) parameters[index]);
				} else if(parameters[index] instanceof Long) {
					statement.setLong(i, (long) parameters[index]);
				} else if(parameters[index] instanceof String) {
					statement.setString(i, (String) parameters[index]);
				} else if(parameters[index] instanceof Float) {
					statement.setFloat(i, (Float) parameters[index]);
				} else if(parameters[index] instanceof Double) {
					statement.setDouble(i, (Double) parameters[index]);
				} else if(parameters[index] instanceof Boolean) {
					statement.setBoolean(i, (Boolean) parameters[index]);
				} else if(parameters[index] instanceof Date) {
					statement.setDate(i, (Date) parameters[index]);
				} else if(parameters[index] instanceof Timestamp) {
					statement.setTimestamp(i, (Timestamp) parameters[index]);
				} else if(parameters[index] instanceof Time) {
					statement.setTime(i, (Time) parameters[index]);
				} else if(parameters[index] == null) {
					statement.setNull(i, java.sql.Types.NULL);
				}
			}			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet query(String query, Object... parameters) {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(query);
			setParameters(statement, query, parameters);
			resultSet =  statement.executeQuery();
			return resultSet;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public static int update(String query, Object... parameters) {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(query);
			setParameters(statement, query, parameters);
			return statement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
