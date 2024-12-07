

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import example.bean.Restaurant;
import example.dao.DaoInterface;
import example.dao.RestaurantDao;

/**
 * Servlet implementation class Restaurentdisplay
 */
@WebServlet("/display")
public class Restaurentdisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Object obj=request.getAttribute("searchedRestaurant");
		Restaurant currentRetaurant=(Restaurant)obj;
		String name=currentRetaurant.getName();
		String cuision=currentRetaurant.getCuisine();
		int branch=currentRetaurant.getBranchCount();
		
		out.println("<h1>Restaurent Details</h1>");
		out.println("<h2>Name: " + name + "</h2>");
		out.println("<h2>Cuisine: " + cuision + "</h2>");
		out.println("<h2>BranchCount: " + branch + "</h2>");
	

		
	}

}
