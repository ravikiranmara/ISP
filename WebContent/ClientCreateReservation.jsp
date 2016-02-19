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
<title>Client Create Reservation</title>
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
	<br>
	<div class="row">
		<div class="col-xs-3">
			<h5><label>Select Hotel:</label></h5>
		</div>
		<div class="col-xs-3">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="hotel">Select
				<span class="caret"></span></button>
				<ul class="dropdown-menu">
					<li><a href="#">Standard</a></li>
				    <li><a href="#">Family</a></li>
				    <li><a href="#">Suite</a></li>
				</ul>
			</div>		
		</div>
		<div class="col-xs-3">
			<h5><label>Number of Rooms:</label></h5>
		</div>
		<div class="col-xs-3">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="rooms">Select
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
					    <li><a href="#">31</a></li>
					</ul>
			</div>
		</div>
	</div><br>
	<div class="row">
		<div class="col-xs-2">
			<h5><label>Check-in day:</label></h5>
		</div>
		<div class="col-xs-1">
			<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="checkin_day">day
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
			    <li><a href="#">31</a></li>
			</ul>
			</div>		
		</div>
		<div class="col-xs-1">
			<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="checkin_month">month
				<span class="caret"></span></button>
			<ul class="dropdown-menu">
				<li><a href="#">JAN</a></li>
			    <li><a href="#">FEB</a></li>
			    <li><a href="#">MAR</a></li>
			    <li><a href="#">APR</a></li>
			    <li><a href="#">MAY</a></li>
			    <li><a href="#">JUN</a></li>
			    <li><a href="#">JUL</a></li>
			    <li><a href="#">AUG</a></li>
			    <li><a href="#">SEP</a></li>
			    <li><a href="#">OCT</a></li>
			    <li><a href="#">NOV</a></li>
			    <li><a href="#">DEC</a></li>
			</ul>
			</div>		
		</div>
		<div class="col-xs-1">
			<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="checkin_year">year
				<span class="caret"></span></button>
			<ul class="dropdown-menu">
				<li><a href="#">2016</a></li>
			    <li><a href="#">2017</a></li>
			    <li><a href="#">2018</a></li>
			    <li><a href="#">2019</a></li>
			    <li><a href="#">2020</a></li>
			    <li><a href="#">2021</a></li>
			    <li><a href="#">2022</a></li>
			    <li><a href="#">2023</a></li>
			    <li><a href="#">2024</a></li>
			    <li><a href="#">2025</a></li>
			</ul>
			</div>		
		</div>
		<div class="col-xs-1"></div>
		<div class="col-xs-2">
			<h5><label>Check-out day:</label></h5>
		</div>
		<div class="col-xs-1">
			<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="checkout_day">day
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
			    <li><a href="#">31</a></li>
			</ul>
			</div>		
		</div>
		<div class="col-xs-1">
			<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="checkout_month">month
				<span class="caret"></span></button>
			<ul class="dropdown-menu">
				<li><a href="#">JAN</a></li>
			    <li><a href="#">FEB</a></li>
			    <li><a href="#">MAR</a></li>
			    <li><a href="#">APR</a></li>
			    <li><a href="#">MAY</a></li>
			    <li><a href="#">JUN</a></li>
			    <li><a href="#">JUL</a></li>
			    <li><a href="#">AUG</a></li>
			    <li><a href="#">SEP</a></li>
			    <li><a href="#">OCT</a></li>
			    <li><a href="#">NOV</a></li>
			    <li><a href="#">DEC</a></li>
			</ul>
			</div>		
		</div>
		<div class="col-xs-1">
			<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="checkout_year">year
				<span class="caret"></span></button>
			<ul class="dropdown-menu">
				<li><a href="#">2016</a></li>
			    <li><a href="#">2017</a></li>
			    <li><a href="#">2018</a></li>
			    <li><a href="#">2019</a></li>
			    <li><a href="#">2020</a></li>
			    <li><a href="#">2021</a></li>
			    <li><a href="#">2022</a></li>
			    <li><a href="#">2023</a></li>
			    <li><a href="#">2024</a></li>
			    <li><a href="#">2025</a></li>
			</ul>
			</div>		
		</div>
		<div class="col-xs-1"></div>
	</div><br>
	<div class="row">
		<div class="col-xs-2">
			<h5><label>Room type:</label></h5>
		</div>
		<div class="col-xs-2">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="hotel">Select
				<span class="caret"></span></button>
				<ul class="dropdown-menu">
					<li><a href="#">Standard</a></li>
				    <li><a href="#">Family</a></li>
				    <li><a href="#">Suite</a></li>
				</ul>
			</div>
		</div>
		<div class="col-xs-8"></div>
	</div><br>	
	<div class="row">
		<div class="col-xs-2">
			<label>Name:</label>
		</div>
		<div class="col-xs-4">
			<input type="text" class="form-control" name="city" id="city" placeholder="First Nmae">
		</div>
		<div class="col-xs-4">
			<input type="text" class="form-control" name="city" id="city" placeholder="Last Nmae">
		</div>
		<div class="col-xs-2"></div>
	</div><br>
	<div class="row">
		<div class="col-xs-2">
			<label>Phone No.</label>
		</div>
		<div class="col-xs-2">
			<input type="text" class="form-control" name="city" id="city" placeholder="Phone No.">
		</div>
		<div class="col-xs-8"></div>
	</div><br>	
	<div class="row">
		<div class="col-xs-2">
			<label>Email:</label>
		</div>
		<div class="col-xs-3">
			<input type="text" class="form-control" name="city" id="city" placeholder="Email">
		</div>
		<div class="col-xs-7"></div>
	</div><br>
	<div class="row">
		<center><a href="ClientReservationTransaction.jsp"><button type="submit" class="btn btn-primary btn-md">Submit</button></a></center>
	</div><br>
</div>
</body>
</html>