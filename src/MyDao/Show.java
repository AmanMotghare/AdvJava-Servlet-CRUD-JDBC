package MyDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MyPojo.ModelClass;

public class Show {
	
	private static final String Show_Query = "SELECT * FROM MYTABLE";
	
	public static ArrayList<ModelClass> ShowData(){
		
		
		
		
		
		ArrayList<ModelClass> list = new ArrayList<ModelClass>();
		
		//both ps & rs points towards a single row.
		
		Connection con;
		try {
			con = GetConnection.Connect();
			
			PreparedStatement ps = con.prepareStatement(Show_Query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				ModelClass pojo = new ModelClass();
				
				pojo.setId(rs.getInt(1));
				pojo.setName(rs.getString(2));
				pojo.setEmail(rs.getString(3));
				pojo.setCity(rs.getString(4));
				pojo.setContact(rs.getString(5));
				pojo.setPassword(rs.getString(6));
				
				list.add(pojo);
			}
			
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;

	}
	
}
