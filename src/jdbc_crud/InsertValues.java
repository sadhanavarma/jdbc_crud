package jdbc_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertValues {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3308/myjdbcdb";
		String user = "root";
		String password = "root";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String query = "Insert into student (id, name, email) Values (?, ?, ?)";
		
		PreparedStatement stmt = con.prepareStatement(query);
		
		stmt.setInt(1, 1);
		stmt.setString(2, "Sadhana");
        stmt.setString(3, "sadhana@gmail.com");

		stmt.executeUpdate();
		System.out.println("Data inserted!");

	        stmt.close();
	        con.close();
	}

}
