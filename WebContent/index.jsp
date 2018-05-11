<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="home.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/4.0.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>

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
		<h3>Welcome To 4CKnowledge</h3>
		<p></p>
	</div>
	<div class="container" style="height:75vh">
		<div style="position:relative; width:100%; height:100%;"><br><br>
			<div class="center" style="width:100%; height:auto; text-align:center;">
				<span class="login-head"><p>SIGN IN</p></span>
				<form action="Login" method="POST" class="login100-form validate-form p-b-33 p-t-5">

					<div class="wrap-input100 validate-input" data-validate = "Enter username">
						<input class="input100" type="text" name="username" placeholder="User name">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<input class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>

					<div class="container-login100-form-btn m-t-32">
						<input  class="login100-form-btn" type="submit" value="Login" >
					</div>

				</form>
			</div>	
			
		</div>
	</div>
</div>

</body>
</html>