package jdbc_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateJdbc {
    public static void main(String[] args) {
        // JDBC connection details
        String url = "jdbc:mysql://localhost:3308/testdb"; // Database name = testdb
        String username = "root"; // your MySQL username
        String password = "root"; // your MySQL password (change to "" if empty)

        try {
            // Step 1: Load the JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the Connection
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Connected to the database!");

            // Step 3: Create Statement
            Statement stmt = con.createStatement();

            // Step 4: Create Table (if not exists)
            String createQuery = "CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY, name VARCHAR(50))";
            stmt.executeUpdate(createQuery);
            System.out.println("📁 Table created!");

            // Step 5: Insert Data
            String insertQuery = "INSERT INTO students VALUES (1, 'Sadhana')";
            stmt.executeUpdate(insertQuery);
            System.out.println("✅ Data inserted!");

            // Step 6: Read Data
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            System.out.println("📋 Students in table:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
            }

            // Step 7: Close connection
            con.close();
            System.out.println("🔒 Connection closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
