package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {
     public static Connection createconnection() {
    	 Connection conn = null;
		   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/footwear1", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 return conn;
     }
}
