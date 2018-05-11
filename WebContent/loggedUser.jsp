<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import ="java.sql.*" %>
<%@page import ="java.util.ArrayList" %>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="it16139404.UserBean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <title>User View</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="home.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/4.0.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

UserBean user=(UserBean)session.getAttribute("currentSessionUser");
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

	<div style="text-align:center;">
		<h2>Welcome <% out.println(user.getName().toUpperCase());%></h2>
		<p></p>
	</div>
	<div class="container" style="height:75vh">
		<div class="col-sm-1" style="height:100%"></div>
		<div class="col-sm-4" style="height:100%">
			<div style="position:relative; width:100%; height:100%">
				<form action="NavigateToUpdatePage" method="GET">
					<input type='hidden' name='uname' value="<%=user.getName() %>" />
						<button type="submit" style="position: absolute; height:60px; width:100%; 
							border:none; background-color:#f78c00; color:white; font-weight:500; font-family:Open Sans; font-size:2em;
							top: 50%; left: 50%; margin-right: -50%; transform: translate(-50%, -50%);">
							<a style="text-decoration:none; color:#253037" href="userChangeDetails.jsp">Update Details</a>
						</button>
				</form>
			</div>
		</div>
		<div class="col-sm-1" style="height:100%"></div>
		<div class="col-sm-1" style="height:100%"></div>
		<div class="col-sm-4" style="height:100%">
			<div style="position:relative; width:100%; height:100%">
				<form action="Logout" method="GET">
					<button type="submit" style="position: absolute; height:60px; width:100%; 
						border:none; background-color:#000000; color:white; font-weight:500; font-family:Open Sans; font-size:2em; 
						top: 50%; left: 50%; margin-right: -50%; transform: translate(-50%, -50%);">
						<span style="text-decoration:none; color:white">Log Out</span>
					</button>
				</form>
			</div>
		</div>
		<div class="col-sm-1"></div>
	</div>
</div>

</body>
</html>