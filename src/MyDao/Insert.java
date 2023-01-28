package MyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import MyPojo.ModelClass;

public class Insert {
	
	private static final String Insert_Query = "INSERT INTO MYTABLE (ID,NAME,EMAIL,CITY,CONTACT,PASSWORD) VALUES (?,?,?,?,?,?)";
	
	public static int InsertData(ModelClass pojo) {
		
		int status = 0;
		
		//Create Statement.
		//Connection is a return type.
		 
		try {
			Connection con = GetConnection.Connect();
			
			PreparedStatement ps = con.prepareStatement(Insert_Query);
			ps.setInt(1, pojo.getId());
			ps.setString(2, pojo.getName());
			ps.setString(3, pojo.getEmail());
			ps.setString(4, pojo.getCity());
			ps.setString(5, pojo.getContact());
			ps.setString(6, pojo.getPassword());
			
			//Execute update.
					
			status= ps.executeUpdate();
			
			con.close();
		
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		return status; 
		
	}
}
