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
	    <div class="form-group">
	      <label for="lbl-firstName" class="center">First Name:</label>
	      <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter First Name">
	    </div>
    </div>
    <div class="container-fluid">
	    <div class="form-group">
	      <label for="lbl-lastName" class="center">Last Name:</label>
	      <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter Last Name">
	    </div>
    </div>
    <div class="container-fluid">
	    <div class="form-group">
	      <label for="lbl-Address1" class="center">Address Line 1:</label>
	      <input type="text" class="form-control" id="address1" name="address1" placeholder="Enter Address 1">
	    </div>
    </div>
    <div class="container-fluid">
	    <div class="form-group">
	      <label for="lbl-Address2" class="center">Address Line 2:</label>
	      <input type="text" class="form-control" id="address2" name="address2" placeholder="Enter Address 2">
	    </div>
    </div>
    <div class="container-fluid">
	    <div class="form-group">
	      <label for="lbl-city" class="center">City:</label>
	      <input type="text" class="form-control" id="city" name="city" placeholder="Enter City">
	    </div>
    </div>
    <div class="container-fluid">
	    <div class="form-group">
	      <label for="lbl-state" class="center">State:</label>
	      <input type="text" class="form-control" id="state" name="state" placeholder="Enter State">
	    </div>
    </div>
    <div class="container-fluid">
	    <div class="form-group">
	      <label for="lbl-postalCode" class="center">Postal Code:</label>
	      <input type="text" class="form-control" id="postalCode" name="postalCode" placeholder="Enter Postal Code">
	    </div>
    </div>
    <div class="container-fluid">
	    <div class="form-group">
	      <label for="lbl-creditCardNumber" class="center">Credit card number:</label>
	      <input type="text" class="form-control" id="creditCardNumber" name="creditCardNumber" placeholder="Enter Credit Card Number">
	    </div>
    </div>
    <div class="container-fluid">
	    <div class="form-group">
	      <label for="lbl-creditCardHolderName" class="center">Credit card Holder Name:</label>
	      <input type="text" class="form-control" id="creditCardHolderName" name="creditCardHolderName" placeholder="Enter Credit Card Holder Name">
	    </div>
    </div>
    <div class="container-fluid">
	    <div class="form-group">
	      <label for="lbl-creditCardNickName" class="center">Credit card Nick Name:</label>
	      <input type="text" class="form-control" id="creditCardNickName" name="creditCardNickName" placeholder="Enter Credit Card Nick Name">
	    </div>
    </div>
    <div class="container-fluid">
	    <div class="form-group">
	      <label for="lbl-creditCardCvv" class="center">Credit card CVV:</label>
	      <input type="text" class="form-control" id="creditCardCvv" name="creditCardCvv" placeholder="Enter Credit Card Cvv">
	    </div>
    </div>
    <div class="container-fluid">
	    <div class="form-group">
	      <label for="lbl-creditCardBalance" class="center">Credit card Balance:</label>
	      <input type="text" class="form-control" id="creditCardBalance" name="creditCardBalance" placeholder="Enter Credit Card Balance">
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

