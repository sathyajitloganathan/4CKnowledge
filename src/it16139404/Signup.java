package it16139404;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
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
		
		String[] interests;
		String interestConcat = "";
		
		try
		{	     		
			System.out.println("HERE");
		     MemberBean member = new MemberBean();
		     member.setName(request.getParameter("name"));
		     member.setUserName(request.getParameter("username"));
		     member.setDOB(request.getParameter("dob"));
		     member.setEmail(request.getParameter("email"));
		     member.setPhoneNumber(request.getParameter("phonenumber"));
		     member.setAddress(request.getParameter("address"));
		     member.setPassword(request.getParameter("password"));
		     
		     interests = request.getParameterValues("interests");
		     for(String value : interests)
		     {
		    	 interestConcat = interestConcat + " " + value;
		     }  
		     
		     
				
		     	response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				
				String name, mobNo, email;
				String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
			    Pattern pattern = Pattern.compile(regex);
			    Pattern pattern2 = Pattern.compile("^[0-9]{10}$");
				boolean valid = true;
				
				name=request.getParameter("name").toString();
				
				mobNo=request.getParameter("phonenumber").toString();
				email=request.getParameter("email").toString();
				
				if(interests == null) {
					out.println("<script type=\"text/javascript\">");
			        out.println("alert('Select atleast one interest.');");
			        out.println("location='signup.jsp';");
			        out.println("</script>");
					System.out.println("Select atleast one interest");
			        valid = false;
				}

		     
				Matcher matcher2 = pattern2.matcher(mobNo);
				if (!matcher2.matches()) {
					out.println("<script type=\"text/javascript\">");
			        out.println("alert('Invalid Mobile No. Cannot contain characters.');");
			        out.println("location='signup.jsp';");
			        out.println("</script>");
			        System.out.println("mob inval");
			        valid = false;
				}

				if (valid) {
					 // Add interests
				     member.setInterest(interestConcat);
				     
					 MemberDAO.addMemberDetails(member);
				     
				     out.println("<script type=\"text/javascript\">");
			         out.println("alert('Registration Successful !!');");
			         HttpSession session=request.getSession();
			 		 session.removeAttribute("currentSessionUser");
			 		 session.invalidate();
			         out.println("location='index.jsp';");
			         out.println("</script>");
				}
		     

		} 	
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		
	}

}
