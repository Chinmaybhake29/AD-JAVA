
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HitCounterServlet
 */
@WebServlet("/hitCounter")
public class HitCounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		boolean newSession = session.isNew();
		int countValue=0;
		if (newSession) {
			countValue=1;
		} else {
			Integer currentCount=(Integer)session.getAttribute("counterValue");
			countValue=currentCount+1;
		}
		session.setAttribute("countValue",countValue);
		RequestDispatcher dispathcher=request.getRequestDispatcher("counter.html");
		out.println("<h1>Count value: "+countValue+"</h1>");
		dispathcher.include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
