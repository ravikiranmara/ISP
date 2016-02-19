<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<!-- Load Custom Scripts and Styles -->
<link rel="stylesheet" type="text/css" href="css/custom_styles.css">
<title>Cancel Reservations</title>
</head>
<body>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
   		<div class="navbar-header">
     		<a class="navbar-brand" href="CustomerHomePage.jsp">Hotels.com</a>
    	</div>
   			<ul class="nav navbar-nav">
     			<li class="active"><a href="CustomerHomePage.jsp">Home</a></li>
    			<li><a href="ManageReservations.jsp">Manage Reservations</a></li>
     	 	</ul>
   		 	<ul class="nav navbar-nav navbar-right">
      			<li><a href="Login.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    		</ul>
	</div>
</nav>
<div class="container ">
	<dev class="row">
		<div class="col-xs-12">
			<center><h3>Reservation Cancellation</h3></center>
		</div>
	</dev>
	<div class="row">
		<div class="col-xs-3"></div>
		<div class="col-xs-3">
			<h5><label>Hotel: Excalibur</label></h5>
		</div>
		<div class="col-xs-3">
			<h5><label>Room type: Family</label></h5>
		</div>
		<div class="col-xs-3">
			<h5><label>cost per day: $45</label></h5>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-3"></div>
		<div class="col-xs-9">
			<h6>The luxurious and exclusive Trump International Hotel & Tower New York is set in the heart of Manhattan, on the Upper West Side, at the junction of Central Park West and Broadway. Central Park is just across the street</h6>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-3">
			<h5><label>A/C Holders Name:</label></h5>
		</div>
		<div class="col-xs-3">
			<h5><label>First Name</label></h5>
		</div>
		<div class="col-xs-3">
			<h5><label>Last Name</label></h5>
		</div>
		<div class="col-xs-3"></div>
	</div>
	<div class="row">
		<div class="col-xs-3">
			<h5><label>Card Type:</label></h5>
		</div>
		<div class="col-xs-3">
			<h5><label>Master Card</label></h5>
		</div>
		<div class="col-xs-3"></div>
		<div class="col-xs-3"></div>
	</div>
	<div class="row">
		<div class="col-xs-3">
			<h5><label>Billing Address:</label></h5>
		</div>
		<div class="col-xs-9">
			<h5><label>Address1</label></h5>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-3"></div>
		<div class="col-xs-9">
			<h5><label>Address2</label></h5>
		</div>
	</div>
	<div class="row">
				<div class="col-xs-2">
					<a href="ReservationCancellationConfirmation.jsp"><button type="submit" class="btn btn-primary btn-sm">Confirm Cancellation</button></a>
				</div>
				<div class="col-xs-2">
					<a href="CustomerHomePage.jsp"><button type="submit" class="btn btn-primary btn-sm">Cancel</button></a>
				</div>
				<div class="col-xs-8"></div>
	</div><br>
</div>
</body>
</html>