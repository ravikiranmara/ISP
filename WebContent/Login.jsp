<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="./css/bootstrap.css">
    <link rel="stylesheet" href="./css/custom.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" type="text/css" href="css/custom_styles.css">
</head>

<script type="text/javascript">
	function validate(){
		var a = document.getElementById("username").value;
		var b = document.getElementById("password").value;
		if(a && b){
			document.getElementById("login-form").action = "Login";
			document.forms[0].submit;
			
			return true;
		}
		else
		{
			alert("Usename or password is empty");
			return false;
		}
	}  
</script>

<body>

	<div>
		<h2><center><label>Login</label></center></h2>
	</div>
  <div class="container-fluid">
	<form id="login-form" class="form-signin" action="Login" method="post">
	    <div class="container-fluid">
	    <div class="form-group">
	      <label for="lbl-username">Username</label>
	      <input id="username" type="text" class="form-control" name="username" placeholder="Enter Username">
	    </div>
    </div>
    <div class="container-fluid">
	    <div class="form-group">
	      <label for="lbl-password" class="center">Password:</label>
	      <input id="password" type="password" class="form-control" name="password" placeholder="Enter password">
	    </div>
    </div>
    <div class="container-fluid">
    	<div class="row form-group text-center">
    		<button onclick="return validate();" type="submit" class="btn btn-default btn-lg btn-block">Login</button>
    	</div>
    </div>
    <div>
     <a href="Registration.jsp">
                Register
            </a>
   </div>
  </form>
</div>

</body> 
</html>

