package jdbc_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDT {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3308/";
		String user = "root";
		String password = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			
			String createDB = "CREATE DATABASE IF NOT EXISTS myjdbcdb";
			stmt.executeUpdate(createDB);
	        System.out.println("Database created successfully!");

	        
			stmt.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace(); 
		}
	}

}
