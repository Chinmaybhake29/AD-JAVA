

import jakarta.servlet.RequestDispatcher;
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
 * Servlet implementation class RestaurantSearch
 */
@WebServlet("/search")
public class RestaurantSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("r_id");
		
		int restaurant_id=Integer.parseInt(id);
		
		DaoInterface<Restaurant, Integer> daoRef=new RestaurantDao();
		Restaurant foundRestaurant=daoRef.retrieveOne(restaurant_id);
		
		if(foundRestaurant==null) {
			RequestDispatcher dispatcher=
			request.getRequestDispatcher("search_restaurant.html");
			out.println("<h2 style='color:red;'>sorry We didn't found id</h2>");
			dispatcher.include(request, response);
		} else {
			RequestDispatcher dispatcher=request.getRequestDispatcher("display");
			request.setAttribute("searchedRestaurant", foundRestaurant);
			dispatcher.include(request, response);
		}
		
	}

}
