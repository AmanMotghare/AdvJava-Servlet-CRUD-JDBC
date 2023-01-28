package MyDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {

	public static Connection Connect() throws SQLException, ClassNotFoundException{
		
		
		//Register The Driver
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Registered");
		
		//Build Connections
		
		Connection con = null;
		
		String url="jdbc:mysql://localhost:3306/jdbcservletproject";
		String username="root";
		String password="abc123";
		
		con = DriverManager.getConnection(url,username,password);
		
		
		return con;
		
	}
}
