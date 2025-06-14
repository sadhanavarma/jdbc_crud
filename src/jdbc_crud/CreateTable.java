package jdbc_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3308/myjdbcdb";
		String user = "root";
		String password = "root";
		
       try {
    	   
    	   Class.forName("com.mysql.cj.jdbc.Driver");
    	   
    	   Connection con = DriverManager.getConnection(url, user, password);
    	   Statement stmt = con.createStatement();
    	   
    	   String createTable = "Create table if not exists Student(id int, name varchar(50), email varchar(50))";
    	   
    	   stmt.executeUpdate(createTable);
    	   System.out.println("Table created successfully!");
    	   
    	   
       }catch(Exception e) {
    	   e.printStackTrace();
       }
	}

}
