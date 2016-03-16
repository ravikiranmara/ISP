<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Load Custom Scripts and Styles -->
<link rel="stylesheet" type="text/css" href="css/custom_styles.css">
<title>View and Book</title>
</head>
<body>

<jsp:include page="headerCustomer.jsp" />

<div class="container">
	<h3>Holel: Excalibur</h3>
	<h3>Place: New York</h3>
	<h3>Description: The luxurious and exclusive Trump International Hotel & Tower New York is set in the heart of Manhattan, on the Upper West Side, at the junction of Central Park West and Broadway. Central Park is just across the street</h3>        
	<h3>Room type: Family</h3>        
	<h3>Rating: 4 Star</h3>
	<h3>Price per day: $45</h3>
	<h3>Amenities: Free Breakfast, Free Wi-Fi, Gym</h3>
	<h3>Distance from port:	10 miles</h3>
</div>
<div class="row"><br>
	<div class="col-xs-1"></div>
	<div class="col-xs-1"></div>
	<div class="col-xs-1">
		<div class="dropdown">
			<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="rooms"> #rooms
			<span class="caret"></span></button>
			<ul class="dropdown-menu">
				<li><a href="#">1</a></li>
			    <li><a href="#">2</a></li>
			    <li><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">5</a></li>
			    <li><a href="#">6</a></li>
			    <li><a href="#">7</a></li>
			    <li><a href="#">8</a></li>
			    <li><a href="#">9</a></li>
			    <li><a href="#">10</a></li>
			    <li><a href="#">11</a></li>
			    <li><a href="#">12</a></li>
			    <li><a href="#">13</a></li>
			    <li><a href="#">14</a></li>
			    <li><a href="#">15</a></li>
			    <li><a href="#">16</a></li>
			    <li><a href="#">17</a></li>
			    <li><a href="#">18</a></li>
			    <li><a href="#">19</a></li>
			    <li><a href="#">20</a></li>
			    <li><a href="#">21</a></li>
			    <li><a href="#">22</a></li>
			    <li><a href="#">23</a></li>
			    <li><a href="#">24</a></li>
			    <li><a href="#">25</a></li>
			    <li><a href="#">26</a></li>
			    <li><a href="#">27</a></li>
			    <li><a href="#">28</a></li>
			    <li><a href="#">29</a></li>
			    <li><a href="#">30</a></li>
			</ul>
		</div>		
	</div>
	<div class="col-xs-1">
		<a href="ReservationTransaction.jsp"><button type="submit" class="btn btn-primary btn-md">Book</button></a>
	</div>
	<div class="col-xs-1">
		<a href="ReservationSearchResults.jsp"><button type="submit" class="btn btn-primary btn-md">Back</button></a>
	</div>
	<div class="col-xs-1"></div>
	<div class="col-xs-1"></div>
	<div class="col-xs-1"></div>
	<div class="col-xs-1"></div>
	<div class="col-xs-1"></div>
	<div class="col-xs-1"></div>
	<div class="col-xs-1"></div>
</div>
</body>
</html>