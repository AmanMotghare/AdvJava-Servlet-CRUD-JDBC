package MyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import MyPojo.ModelClass;

public class Update {
	
	private static final String Update_Query = "UPDATE MYTABLE SET NAME=?,EMAIL=?,CITY=?,CONTACT=?,PASSWORD=? WHERE ID=?";

	public static int UpdateDetails(ModelClass pojo){
		
		Connection con;
		int status=0 ;
		try {
			
			con = GetConnection.Connect();
			
			PreparedStatement ps = con.prepareStatement(Update_Query);
			
			ps.setString(1, pojo.getName());
			ps.setString(2, pojo.getEmail());
			ps.setString(3, pojo.getCity());
			ps.setString(4, pojo.getContact());
			ps.setString(5, pojo.getPassword());
			ps.setInt(6, pojo.getId());
			
			status = ps.executeUpdate();
			
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}
	
}
