package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import MyDao.GetConnection;
import MyPojo.ModelClass;

@WebServlet(name = "savedetails", urlPatterns = { "/savedetails" })
public class SaveDetails extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		
		String Name = request.getParameter("name");
		String Email = request.getParameter("email");
		String City = request.getParameter("city");
		String Contact = request.getParameter("contact");
		String Password = request.getParameter("password");
		String RepeatPassword = request.getParameter("repeatpassword");
		
		if(!Password.equals(RepeatPassword)){
			
			dispatcher.include(request,response);
			out.print("<script>alert('Passwords do not match !!')</script>");
		}
		else{
			
			ModelClass pojo = new ModelClass();
			
			pojo.setName(Name);
			pojo.setEmail(Email);
			pojo.setContact(Contact);
			pojo.setCity(City);
			pojo.setPassword(Password);
			
			
			int status = MyDao.Insert.InsertData(pojo);
		
			
			if(status>0){
				dispatcher.include(request,response);
				out.print("<script>alert('User Registration Done Successfully!')</script>");
			}
			else{	
				dispatcher.include(request,response);
				out.print("<script>alert('User Registration Failed')</script>");
			}
		}
		
		
		
//		out.close();
	}

}
