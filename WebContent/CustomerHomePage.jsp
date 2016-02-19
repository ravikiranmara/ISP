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
<title>Customer Home Page</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

<!-- Load Custom Scripts and Styles -->
<link rel="stylesheet" type="text/css" href="css/custom_styles.css">

</head>
<body>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
   		<div class="navbar-header">
     		<a class="navbar-brand" href="#">Hotels.com</a>
    	</div>
   			<ul class="nav navbar-nav">
     			<li class="active"><a href="#">Home</a></li>
    			<li><a href="ManageReservations.jsp">Manage Reservations</a></li>
     	 	</ul>
   		 	<ul class="nav navbar-nav navbar-right">
      			<li><a href="Login.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    		</ul>
	</div>
</nav>
<form role="form" action= "ReservationSearchResults.jsp">
	<div class="container ">
		<div class="hotelSearchBox">
			<h1><center>Welcome Guests</center></h1>
			<div class="row">
	  			<div class="col-xs-6">
					<div class="form-group">
				  		<label for="search">Search:</label>
				  		<input type="text" class="form-control" id="search" placeholder="Hotel Name">
					</div>
					<div class="row">
						<div class="col-xs-6">
							<div>
								<label for="checkin">Check-in:</label>
							</div>
							<div class="row">
								<div class="col-xs-4">
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
								<div class="col-xs-4">
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
								<div class="col-xs-4">
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
							</div>
						</div>
						<div class="col-xs-6">
							<label for="checkout">Check-out:</label>
							<div class="row">
								<div class="col-xs-4">
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
								<div class="col-xs-4">
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
								<div class="col-xs-4">
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
							</div>
						</div>	
					</div><br>
					<div class="form-group">
	     				<label>Location city:</label>
	     				<input type="text" class="form-control" name="city" id="city" placeholder="Location city">
	    			</div>
					<label>Guests:</label><br>
					<div class="row">
						<div class="col-xs-3">
							<div class="dropdown">
				  							<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="adults">Adults
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
						<div class="col-xs-3">
							<div class="dropdown">
			  							<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="children">Children
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
										</ul>
							</div>	
						</div>
						<div class="col-xs-3"></div>
						<div class="col-xs-3">	</div>
					</div><br>
					<label> Number of: </label><br>
					<div class="row">
						<div class="col-xs-3">
							<div class="dropdown">
			  							<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="rooms">Rooms
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
						<div class="col-xs-3">
							<div class="dropdown">
			  							<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="type">Type
										<span class="caret"></span></button>
										<ul class="dropdown-menu">
											<li><a href="#">Standard</a></li>
										    <li><a href="#">Family</a></li>
										    <li><a href="#">Suite</a></li>
										</ul>
							</div>	
						</div>
						<div class="col-xs-3"></div>
						<div class="col-xs-3"></div>
					</div>
				</div>
				<div class="col-xs-6">
				</div>
			</div><br>
			<div class="row">
				<div class="col-xs-3">
					<div class="checkbox">
		  				<label><input type="checkbox" value="">Bathtub in room</label>
					</div>
				</div>
				<div class="col-xs-3">
					<div class="checkbox">
		  				<label><input type="checkbox" value="">Free breakfast</label>
					</div>
				</div>
				<div class="col-xs-3">
					<div class="checkbox">
		  				<label><input type="checkbox" value="">Free Wi-Fi</label>
					</div>
				</div>
				<div class="col-xs-3">
					<div class="checkbox">
		  				<label><input type="checkbox" value="">Gym</label>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-3">
					<div class="checkbox">
		  				<label><input type="checkbox" value="">Paid Internet access</label>
					</div>
				</div>
				<div class="col-xs-3">
					<div class="checkbox">
		  				<label><input type="checkbox" value="">Pool</label>
					</div>
				</div>
				<div class="col-xs-3">
					<div class="checkbox">
		  				<label><input type="checkbox" value="">Pet friendly</label>
					</div>
				</div>
				<div class="col-xs-3"></div>
			</div>
		</div>
	</div>
	<div>
		<br>
		<center><button type="submit" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-search"></span>Search</button></center>
	</div>
</form>
</body>
</html>
