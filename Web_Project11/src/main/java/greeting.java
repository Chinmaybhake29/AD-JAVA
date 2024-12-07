

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class greeting
 */
@WebServlet("/greet")
public class greeting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void init() {
		System.out.println("Inside Init()");
	}
	public void destroy() {
		System.out.println("Inside Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//This method gets invoked when servlet is requested
		//
	   PrintWriter wt=response.getWriter();
		String s1="<h1 style='color:red'>Hello World</h1>";
		wt.println(s1);
	}

}
