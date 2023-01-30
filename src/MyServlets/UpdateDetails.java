package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyDao.Show;
import MyPojo.ModelClass;


@WebServlet(name = "update", urlPatterns = { "/update" })

public class UpdateDetails extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		
		ModelClass pojo = Show.getUserById(id);
		
		out.print("<head>"
				+ "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet "
				+ "integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>"
				+ "<meta charset='ISO-8859-1'>"
				+ "<title>UPDATE DETAILS|| SERVLET CRUD </title>"
				+ "</head>");
		
		out.print("<body>"
				+ "<section class='vh-100' style='background-color: #eee;'>"
						+ "<div class='container h-100'>"
						+ "<div class='row d-flex justify-content-center align-items-center h-100'>"
						+ "<div class='col-lg-12 col-xl-11'>"
						+ "<div class='card text-black' style='border-radius: 25px;'>"
						+ "<div class='card-body p-md-5'>"
						+ "<div class='row justify-content-center'>"
						+ "<div class='col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1'>"
						+ "<p class='text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4'>UPDATE DETAILS</p>");
		
//		FROM START
		
		out.print("<form class='mx-1 mx-md-4' action='setupdatedetails' method='post'>"
				+ "<div class='d-flex flex-row align-items-center mb-4'>"
				+ "<i class='fas fa-user fa-lg me-3 fa-fw'></i>"
				+ "<div class='form-outline flex-fill mb-0'>"
				+"<input type = 'hidden'  name = 'id' value = '"+pojo.getId()+"'/>"
				+ "<input type='text' id='name' name='name'"
				+ " value='"+pojo.getName()+"'"
				+ "class='form-control' placeholder='Your Name'  required />"
				+ "</div>"
				+ "</div>"
				
				+ "<div class='d-flex flex-row align-items-center mb-4'>"
				+ "<i class='fas fa-envelope fa-lg me-3 fa-fw'></i>"
				+ "<div class='form-outline flex-fill mb-0'>"
				+ "<input type='email' id='email' name='email'"
				+ " value='"+pojo.getEmail()+"' "
				+ " class='form-control' placeholder='Your Email'  required />"
				+ "</div>"
				+ "</div>"
	
				+ "<div class='d-flex flex-row align-items-center mb-4'>"
				+ "<i class='fas fa-envelope fa-lg me-3 fa-fw'></i>"
				+ "<div class='form-outline flex-fill mb-0'>"
				+ "<input type='text' id='city' name='city' "
				+ " value='"+pojo.getCity()+"' "
				+ " class='form-control' placeholder='Your City'  required />"
				+ "</div>"
				+ "</div>"
				
				+ "<div class='d-flex flex-row align-items-center mb-4'>"
				+ "<i class='fas fa-envelope fa-lg me-3 fa-fw'></i>"
				+ "<div class='form-outline flex-fill mb-0'>"
				+ "<input type='tel' id='contact' name='contact'  "
				+ " value='"+pojo.getContact()+"' "
				+ "class='form-control' placeholder='Your Contact Number' required />"
				+ "</div>"
				+ "</div>"
				
				+ "<div class='d-flex flex-row align-items-center mb-4'>"
				+ "<i class='fas fa-lock fa-lg me-3 fa-fw'></i>"
				+ "<div class='form-outline flex-fill mb-0'>"
				+ "<input type='text' id='password'  name='password'"
				+ " value='"+pojo.getPassword()+"' "
				+ "  class='form-control' placeholder='Your Password' required />"
				+ "</div>"
				+ "</div>"
				
				+ "<div class='d-flex flex-row align-items-center mb-4'>"
				+ "<i class='fas fa-key fa-lg me-3 fa-fw'></i>"
				+ "<div class='form-outline flex-fill mb-0'>"
				+ "<input type='text' id='repeatpassword' name='repeatpassword' class='form-control'  placeholder='Repeat Your Password'  required />"
				+ "</div>"
				+ "</div>"
				
				+ "<div class='form-check d-flex justify-content-center mb-5'>"
				+ "<input class='form-check-input me-2' type='checkbox' value='' id='form2Example3c' />"
				+ "<label class='form-check-label' for='form2Example3'>"
				+ "I agree all statements in <a href='https://i.pinimg.com/originals/53/fc/19/53fc192137d66ef16001233df897e0d1.jpg'>Terms of service</a>"
				+ "</label>"
				+ "</div>"
				
				+ "<div class='d-flex justify-content-center mx-4 mb-3 mb-lg-4'>"
				+ "<button type='submit' class='btn btn-primary btn-lg'>Update</button>"
				+ "</div>"
				+ "<a href='show' style='padding-left:39%; text-align:center; text-decoration:none'>VIEW USERS</a>"
				+ "</form>");
		
		out.print("</div>"
				+ "<div class='col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2'>"
				+ "<img src='images/coverimg.webp'"
				+ "class='img-fluid' alt='Sample image'>"
				+ "</div>");
		
		out.print("</div>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "</section>"
				+ "</body>	");
		
//		FORM END
		
	}

}
