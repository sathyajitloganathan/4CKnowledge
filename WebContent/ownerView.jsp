<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="it16139404.UserBean"%>

<%@page import ="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>

<!-- this is for bootstrap arshad**************************************************************************************************-->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
	html, body {
	    font: 14px helvetica neue, helvetica, arial, sans-serif;
	    width: 100%;
	    height: 100%;
	    margin: 0;
	    padding: 0;
	    background-color: white;
	}
	
	#cy {
	    position: absolute;
	    left: 0;
	    top: 0;
	    right: 0;
	    bottom: 0;
	    background-color: white;
	    padding: 20px;
	}
	
	#cy-pannel-body {
	    background-color: white;
	}
	
	.btn-filter {
	    background-color: transparent;
	    box-shadow: none !important;
	    width: 100%;
	    height: 100%;
	    border-radius: 0px 0px;
	    font-weight: bold;
	    font-size: 12px;
	}
	
	.filter-dropdown {
	    padding-top: 7px;
	    padding-bottom: 7px;    
	    margin-right: 30px;
	}
	
	.container .dropdown .dropdown-menu a:hover {
	    color: #fff;
	    background-color: #1DA8D2;
	    border-color: #fff;
	}
	
	.dropdown .btn:active {
	    color: white;
	    background: cyan;
	    color: #000;
	}
	
	.dropdown .btn:focus {
	    background: #0087C1;
	    color: #000;
	    color: white;
	}
	
	.header-row td {
	    padding: 0;
	    vertical-align: middle;
	    text-align: center;
	    font-weight: bold;    
	}
	
	#blockchain-table {
	    font-size: 12px;
	}
	
	.badge {
	    padding: 5px;
	    font-size: 12px;
	}
	
	.badge-warning {
	    color: white;
	}
	
	.filter-checkbox {
	    vertical-align: middle;
	    margin-top: 2px;
	    float: right;
	}
</style>


<script>
function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("userID");
  filter = input.value.toUpperCase();
  table = document.getElementById("userList");
  tr = table.getElementsByTagName("tr");
  for (i = 1; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>

</head>
<body>

<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
UserBean user=(UserBean)session.getAttribute("currentSessionO");
if(user.getName()==null){
	response.sendRedirect("index.jsp");
}
%>
       <nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">4CKnowledge</a>
		    </div>
		    <ul class="nav navbar-nav">
		      <li class="active"><a href="login.jsp">Sign In</a></li>
		      <li><a href="signup.jsp">Sign Up</a></li>
		    </ul>
		  </div>
		</nav>
		<div class="container">
		<h3>Welcome  <% out.println(user.getName().toUpperCase());%></h3>
		<br><br>
			<form action="LogoutO">
				<div class="col-sm-4" style="padding:0">
					<input style="width:100%; height:40px;" type="text" id="userID" onkeyup="myFunction()" placeholder="Enter User Name" title="Type in a name">
				</div>
				<!-- <div class="col-sm-1" style="padding:0">
					<button style="background-color:#253037; 
					color: white; font-family:OpenSans; border:none; border-radius:5px; width:100%; height:20px">
						Search
					</button>
				</div> -->
				<div class="col-sm-2" style="padding:0"></div>
				<div class="col-sm-4" style="padding:0"></div>
				<div class="col-sm-2" style="padding:0">
					<input type="submit" value="Logout" style="background-color:#253037; color: white; font-family:OpenSans; border:none; border-radius:5px; width:100%; height:40px">
				</div>
					
			</form>
		</div>
		<br/><br/><br/>
		

        <div class="container" style="margin-top:10px">
            <div class="row">                
                <div class="col-md-12">                    
                        <table id="userList" class="table table-hover table-bordered">
                            <thead>
                                <tr class="header-row">
                                    <td>Name</td>
                                    <td>User Name</td>
                                    <td>Address</td>
                                    <td>DOB</td>
                                    <td>Email</td>
                                    <td>Phone Number</td>
                                    <td>Interests</td>
                                </tr>
                            </thead>
                            <tbody>
                            <%
							  try{
								  Connection con = null;
									
									String url = "jdbc:mysql://localhost:3307/4cknowledge";
									String userdb = "root";
									String passworddb = "";
									
								  String query="select * from user where type='u' or type='U'; ";
								  Connection conn=DriverManager.getConnection(url, userdb, passworddb);
								  Statement stmt=conn.createStatement();
								  ResultSet rs=stmt.executeQuery(query);
								  while(rs.next())
								  {
									  %>

                                    <tr>
									  <td><%=rs.getString("name")%></td>
									  <td><%=rs.getString("username") %></td>
									  <td><%=rs.getString("address") %></td>
									  <td><%=rs.getString("dob") %></td>
									  <td><%=rs.getString("email") %></td>
									  <td><%=rs.getString("phonenumber") %></td>
									  <td><%=rs.getString("interests")%></td>
								  	</tr>
								   <%
									  }
									  rs.close();
									  stmt.close();
									  conn.close();
								  }
								  
								  catch(Exception e)
								  {
								  e.printStackTrace();
								  }
								  %>
						  </tbody>
                        </table>
                    </div>                
            </div>
        </div>
    </body>
</html>