package it16139404;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	String name = "";
	String email = "";
	String pass = "";
	
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			name = request.getParameter("name");
			email = request.getParameter("email");
			pass = request.getParameter("pw");
			
			if(name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
				RequestDispatcher ds = request.getRequestDispatcher("registration.jsp");
				ds.include(request, response);
			}
			else {
				String sql = "INSERT INTO `member` (`name`, `email`, `pass`) VALUES ('"+ name +"', '"+ email +"', '" +pass+ "')";
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/4cknowledge", "root", "");
				PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
						
				ps.executeUpdate();
				PrintWriter out = response.getWriter();
				out.println("Success");

			}
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
