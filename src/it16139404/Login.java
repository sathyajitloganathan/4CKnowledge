package it16139404;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		try
		{	    
			 PrintWriter out=response.getWriter();
		     UserBean user = new UserBean();
		     user.setUserName(request.getParameter("username"));
		     user.setPassword(request.getParameter("password"));

		     user = UserDAO.login(user);

		     
		     if (user.isValid())
		     {
		    	 if(user.getType().equals("a") || user.getType().equals("A")) {
		    		 System.out.println("ADMIN");
		    		 HttpSession session = request.getSession(true);	    
			         session.setAttribute("currentSessionA",user);
		    		 response.sendRedirect("adminView.jsp"); //logged-in page
		    	 }
		    	 else if(user.getType().equals("o") || user.getType().equals("O")) {
		    		 System.out.println("OWNER");
		    		 HttpSession session = request.getSession(true);	    
			         session.setAttribute("currentSessionO",user);
		    		 response.sendRedirect("ownerView.jsp"); //logged-in page
		    	 }
		    	 else if(user.getType().equals("u") || user.getType().equals("U")) {
		    		 System.out.println("USER");
		    		 HttpSession session = request.getSession(true);	    
			         session.setAttribute("currentSessionUser",user); 
			         response.sendRedirect("loggedUser.jsp"); //logged-in page  
		    	 }
		              		
		     }
		     else 
		    	out.println("<script type=\"text/javascript\">");
		        out.println("alert('Invalid Login, Please Enter correct Credentials');");
		        out.println("location='index.jsp';");
		        out.println("</script>");
				System.out.println("Invalid Login");
			 } 
		


		
				
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
	}

}
