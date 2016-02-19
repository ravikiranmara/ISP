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
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- Load Custom Scripts and Styles -->
<link rel="stylesheet" type="text/css" href="css/custom_styles.css">
<title>Client Home Page</title>
</head>
<body>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
   		<div class="navbar-header">
     		<a class="navbar-brand" href="ClientHomePage.jsp">Hotels.com</a>
    	</div>
   			<ul class="nav navbar-nav">
     			<li class="active"><a href="ClientHomePage.jsp">Home</a></li>
    			<li><a href="ManageHotels.jsp">Manage Hotels</a></li>
    			<li><a href="ViewCurrentReservations.jsp">View Current Reservations</a></li>
    			<li><a href="ClientCreateReservation.jsp">Client Create Reservation</a></li>
     	 	</ul>
   		 	<ul class="nav navbar-nav navbar-right">
      			<li><a href="Login.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    		</ul>
	</div>
</nav>
<div class="container ">
	<center><h2><label>Welcome Clients</label></h2></center>
	<center>
		<div class="row">
			<div class="col-xs-4">
				<a href="ManageHotels.jsp"><button type="submit" class="btn btn-primary btn-sm">Manage Hotels</button></a>
			</div>
			<div class="col-xs-4">
				<a href="ViewCurrentReservations.jsp"><button type="submit" class="btn btn-primary btn-sm">View Current Reservations</button></a>
			</div>
			<div class="col-xs-4">
				<a href="ClientCreateReservation.jsp"><button type="submit" class="btn btn-primary btn-sm">Client Create Reservation</button></a>
			</div>
		</div><br>
	</center>
</div>
</body>
</html>