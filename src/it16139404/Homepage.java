package it16139404;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Homepage
 */
@WebServlet("/Homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Homepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PrintWriter out=response.getWriter();
		
		out.println("<h1> Hello" + request.getParameter("usertype") +" </h1>");

		 if (request.getParameter("usertype") == "Regular User")
	     {
	          response.sendRedirect("userlogin.jsp"); //logged-in page      		
	     }
	     else if (request.getParameter("usertype") == "Administrator")
	     {
	          response.sendRedirect("adminlogin.jsp"); //logged-in page      		
	     }
	     else if (request.getParameter("usertype") == "Owner")
	     {
	          response.sendRedirect("login.jsp"); //logged-in page      		
	     }
	}

}
