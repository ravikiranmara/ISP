<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/custom.css">
    <link rel="stylesheet" href="../custom_scripts/custom_styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" type="text/css" href="css/custom_styles.css">
  
</head>

	<script type="text/javascript">
	function validate(){
		var a = document.getElementById("password").value;
		var b = document.getElementById("retypepassword").value;
		if(a == b){
			document.getElementById("reg1").action = "Registration";
			document.forms[0].submit;
			return true;
		}
		else{
			alert("password do not match");
			return false;
		}
	}  
	</script>


<body>
	<div>
		<h2><center><label>Please Register</label></center></h2>
	</div>
  <div class="container-fluid">
	<form id = "reg1" class="form-signin" action="Registration" method="post">
	    <div class="container-fluid">
	    <div class="form-group">
	      <label for="lbl-username">Username</label>
	      <input type="text" class="form-control" name="username" placeholder="Enter Username">
	    </div>
    </div>
    <div class="container-fluid">
	    <div class="form-group">
	      <label for="lbl-password" class="center">Password:</label>
	      <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
	    </div>
    </div>
    <div class="container-fluid">
	    <div class="form-group">
	      <label for="lbl-retype-password" class="center">Confirm Password:</label>
	      <input type="password" class="form-control" id="retypepassword" name="retypepassword" placeholder="Enter password">
	    </div>
    </div>
    <div class="container-fluid">
	    <div class="form-group">
	      <label for="UserType" class="center">Register As </label>
	      	<div class="radio">
				<label><input type="radio" name="usertype" value="Client">Client</label>
			</div>
			<div class="radio">
			  <label><input type="radio" name="usertype" value="Customer">Customer</label>
			</div>
	    </div>
    </div>
    
    <div class="container-fluid">
    	<div class="row form-group text-center">
    		<button onclick="return validate();" type="submit" class="btn btn-default btn-lg btn-block">Register</button>
    	</div>
    </div>
    
  </form>
</div>
</body> 
</html>

