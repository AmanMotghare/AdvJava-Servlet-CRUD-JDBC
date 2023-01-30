package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyDao.Update;
import MyPojo.ModelClass;

/**
 * Servlet implementation class SetUpdateDetails
 */
@WebServlet(name = "setupdatedetails", urlPatterns = { "/setupdatedetails" })
public class SetUpdateDetails extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("show");
		
		String uid = request.getParameter("id");
		int id = Integer.parseInt(uid);
		
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
			
			pojo.setId(id);
			pojo.setName(Name);
			pojo.setEmail(Email);
			pojo.setContact(Contact);
			pojo.setCity(City);
			pojo.setPassword(Password);
			
			
			int status = Update.UpdateDetails(pojo);
		
			
			if(status>0){
				response.sendRedirect("show");
			}
			else{	
				out.print("<script>alert('Cannot update Data !!')</script>");
			}
		}
	}

}
