package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyDao.Delete;

/**
 * Servlet implementation class DeleteDetails
 */
@WebServlet("/delete")
public class DeleteDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteDetails() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("show");
		
		String idvalue = request.getParameter("id");
		int id = Integer.parseInt(idvalue);
		
		Delete.DeleteUser(id); 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("show");
		dispatcher.include(request, response);
	}
	

}
