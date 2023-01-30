package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyDao.Show;
import MyPojo.ModelClass;

/**
 * Servlet implementation class ShowDetails
 */
@WebServlet(name = "show", urlPatterns = { "/show" })
public class ShowDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int num=1;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		ArrayList<ModelClass> list =  Show.ShowData();
			
		out.print("<html>");
		out.print("<head>");
		out.print("<title>SHOW ALL USERS || SERVLET CRUD</title>");
		
		out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css' integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO'crossorigin='anonymous'></script>");

		
		out.print("</head>");
		out.print("<body>");
		
		out.print("<div class='container'>");
		out.print("<br>");
		out.print(" <td><a href=index.html class ='btn btn-outline-secondary'>Add New Record</a></td><br><br>");
		
		out.print("<table class='table table-striped'>");
		out.print("<thead>");
		out.print("<tr>");
		out.print("<th scope='col'>SR. NO.</th>");
		out.print("<th scope='col'>ID</th>");
		out.print("<th scope='col'>NAME</th>");
		out.print("<th scope='col'>EMAIL</th>");
		out.print("<th scope='col'>CITY</th>");
		out.print("<th scope='col'>PH. NUMBER</th>");
		out.print("<th scope='col'>PASSWORD</th>");
		out.print("<th scope='col'>ACTION</th>");
		out.print("</tr>");
		out.print("</thead>");
		out.print("<tbody>");
		
		for(ModelClass pojo : list){
			
			
			out.print("<tr>");
			out.print(" <th scope='row'>"+ num +" . "+"</th>");
			out.print(" <td>"+pojo.getId()+"</td>");
			out.print(" <td>"+pojo.getName()+"</td>");
			out.print(" <td>"+pojo.getEmail()+"</td>");
			out.print(" <td>"+pojo.getCity()+"</td>");
			out.print(" <td>"+pojo.getContact()+"</td>");
			out.print(" <td>"+pojo.getPassword()+"</td>");
			out.print(" <td><a class='btn btn-info' href=update?id="+pojo.getId()+">Edit</a>&nbsp&nbsp"
					+ "<a class='btn btn-danger' href=delete?id="+pojo.getId()+">Delete</a></td>");
			out.print("</tr>");
			num++;
			
		}
		out.print("</tbody>");
		out.print("</table>");
		out.print("</div>");

	}

	

}
