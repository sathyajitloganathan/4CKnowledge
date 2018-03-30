package it16139404;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String pass = request.getParameter("pw");
			
			if(name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
				RequestDispatcher ds = request.getRequestDispatcher("registration.jsp");
				ds.include(request, response);
			}
			else {
				String sql = "UPDATE `member` SET `name` = '"+ name +"', `pass` = '"+ pass +"' WHERE `member`.`email` = '"+ email +"'";
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/4cknowledge", "root", "");
				PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
						
				ps.executeUpdate();
				PrintWriter out = response.getWriter();
				out.println("Success");

			}
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			PrintWriter out = response.getWriter();
			out.println(e.toString());
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
