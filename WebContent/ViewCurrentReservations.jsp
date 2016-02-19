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
<title>View Current Reservations</title>
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
<div class="container">
  <h2>Search Results</h2>
  <table class="table">
    <thead>
      <tr>
        <th>Hotel name</th>
        <th>Hotel address</th>
        <th>Room type</th>
        <th>Price per night</th>
        <th>#rooms</th>
        <th>Name</th>
        <th>Chkin Date</th>
        <th>Chkout Date</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>Trump</td>
        <td>Las Vegas</td>
        <td>Standard</td>
        <td>$35</td>
        <td>1</td>
        <td>First Nmae, Last Name</td>
        <td>Day, Month, Year</td>
        <td>Day, Month, Year</td>
      </tr>
      <tr>
        <td>Excalibur</td>
        <td>New York</td>
        <td>Family</td>
        <td>$45</td>
        <td>1</td>
        <td>First Nmae, Last Name</td>
        <td>Day, Month, Year</td>
        <td>Day, Month, Year</td>
      </tr>
      <tr>
        <td>Bellagio</td>
        <td>Las Vegas</td>
        <td>Suite</td>
        <td>$60</td>
        <td>1</td>
        <td>First Nmae, Last Name</td>
        <td>Day, Month, Year</td>
        <td>Day, Month, Year</td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>