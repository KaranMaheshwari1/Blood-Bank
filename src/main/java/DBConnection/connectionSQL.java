package DBConnection;

import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionSQL {
	
		public static Connection GetConnection() {
			
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(Exception ex){
				ex.printStackTrace();
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Blood", "root", "root");
				if(con !=null) {
					System.out.println("Connected");
				}else {
					System.out.println("Not Connected");
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			return con;
			
		}
}
