package MyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	
	private final  static String Delete_Query= " DELETE FROM MYTABLE WHERE ID = ?"; 
	
	public static int DeleteUser(int id){
		
		int status = 0;
		
		Connection con;
		try {
			con = GetConnection.Connect();
			
			PreparedStatement ps = con.prepareStatement(Delete_Query);
			
			ps.setInt(1, id);
			
			status=ps.executeUpdate();
			
			con.close();
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return status;
	
	}

}
