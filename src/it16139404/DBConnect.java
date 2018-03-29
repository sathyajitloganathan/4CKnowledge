package it16139404;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static Connection getConnection() throws SQLException{
		
		Connection con = null;
		
		String url = "jdbc:mysql://localhost:3307/4cknowledge";
		String user = "root";
		String password = "";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			con = DriverManager.getConnection(url, user, password);
			
			return con;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		
		return null;
	}
	public static void main(String[] args) throws SQLException {
		
		if(getConnection() != null) {
			System.out.println("Connection Successful");
		}
	}
}
