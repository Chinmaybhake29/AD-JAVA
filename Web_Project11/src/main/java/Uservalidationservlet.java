

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import example.bean.User;
import example.bean.UserValidator;

/**
 * Servlet implementation class Uservalidationservlet
 */
@WebServlet("/dovalidate")
public class Uservalidationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("uid");
		String password=request.getParameter("pwd");
		
		User userid=new User(username,password);
		boolean valid=UserValidator.isValid(userid);
		
		
		String success="<h1 style='color:green'>Sucessfully login</h1>";
		String Failed="<h1 style='color:red'>Sorry! Access denied</h1>";

		if(username.equals("admin")&&password.equals("abc123")) {
			out.println(success);
		} else {
			out.println(Failed);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
