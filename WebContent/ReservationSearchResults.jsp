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
<title>Reservation search results</title>
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
<div class="container">
  <h2>Search Results</h2>
  <table class="table">
    <thead>
      <tr>
        <th>Hotel name</th>
        <th>Hotel address</th>
        <th>Hotel description</th>
        <th>Room type</th>
        <th>Hotel rating</th>
        <th>Price per night</th>
        <th>Amenities available</th>
        <th>View/Book</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>Trump</td>
        <td>Las Vegas</td>
        <td>The luxurious and exclusive Trump International Hotel & Tower New York is set in the heart of Manhattan, on the Upper West Side, at the junction of Central Park West and Broadway. Central Park is just across the street</td>
        <td>Standard</td>
        <td>3</td>
        <td>$35</td>
        <td>Free WI-Fi, Pool, Pet Friendly</td>
        <td><a href="View_BookReservations.jsp"><button type="submit" class="btn btn-primary btn-sm">View and Book</button></a></td>
      </tr>
      <tr>
        <td>Excalibur</td>
        <td>New York</td>
        <td>The luxurious and exclusive Trump International Hotel & Tower New York is set in the heart of Manhattan, on the Upper West Side, at the junction of Central Park West and Broadway. Central Park is just across the street</td>
        <td>Family</td>
        <td>4</td>
        <td>$45</td>
        <td>Free Breakfast, Free Wi-Fi, Gym</td>
        <td><a href="View_BookReservations.jsp"><button type="submit" class="btn btn-primary btn-sm">View and Book</button></a></td>
      </tr>
      <tr>
        <td>Bellagio</td>
        <td>Las Vegas</td>
        <td>The luxurious and exclusive Trump International Hotel & Tower New York is set in the heart of Manhattan, on the Upper West Side, at the junction of Central Park West and Broadway. Central Park is just across the street</td>
        <td>Suite</td>
        <td>5</td>
        <td>$60</td>
        <td>Free Breakfast, Free Wi-Fi, Gym, Free WI-Fi, Pool, Pet Friendly</td>
        <td><a href="View_BookReservations.jsp"><button type="submit" class="btn btn-primary btn-sm">View and Book</button></a></td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>