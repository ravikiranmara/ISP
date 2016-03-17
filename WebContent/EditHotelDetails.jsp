<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>


<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Load Custom Scripts and Styles -->
<link rel="stylesheet" type="text/css" href="css/custom_styles.css">
<link rel="stylesheet" type="text/css" href="css/custom.css">
<title>Edit Hotel Details</title>
</head>
<body>

<jsp:include page="headerClient.jsp" />


<%@ page 
import="java.util.ArrayList"
import="modelObject.Hotel"
import="utils.globals"
%>

<%

	Hotel h = (Hotel)session.getAttribute(globals.session_editHotelObject);
%>


<div class="container ">
	<br>
	<div class="row">
		<div class="col-xs-3">
			<h5><label>Hotel Name:</label></h5>
		</div>
		<div class="col-xs-3">
			<input type="text" class="form-control" name="name" id="hotelname" placeholder="Name" value=<%=h.getName() %>>
		</div>
		<div class="col-xs-3"></div>
	</div>
	<div class="row">
		<div class="col-xs-3">
			<h5><label>Description:</label></h5>
		</div>
		<div class="col-xs-9">
			<input type="text" class="form-control" name="description" id="Description" placeholder="Description" value=<%= h.getDescription() %>>
		</div>
	</div>
	<br>
	<div class="row">
	
	<div class="col-xs-3">
			<label>Location city:</label>
		</div>
		<div class="col-xs-3">
			<input type="text" class="form-control" name="city" id="city" placeholder="Location city" value=<%= h.getCity() %>>
	</div>
	<div class="row">	
		<div class="col-xs-3">
			<label>Location State:</label>
		</div>
		<div class="col-xs-3">
			<input type="text" class="form-control" name="state" id="state" placeholder="State" value=<%= h.getState() %>>
		</div>
	</div>
	</div>
	
	<div class="col-xs-3">
			<h5><label>Room Type </label></h5>
		</div>
	<div class="dropdown  col-sm-3">
        <select name="roomtype" class="form-control"> 
        	<option value=1>Standard</option>
        	<option value=2>Family</option>
        	<option value=3>Suite</option>
		</select>
    </div>
    <br>
	<div class="row">
		<div class="col-xs-3">
			<h5><label>Total no. of rooms:</label></h5>
		</div>
		<div class="col-xs-3">
			<input type="text" class="form-control" name="numrooms" id="numrooms" placeholder="Number">
		</div>
	</div>
	<div class="row">	
		<div class="col-xs-3">
			<label>Price:</label>
		</div>
		<div class="col-xs-3">
			<input type="text" class="form-control" name="price" id="price" placeholder="price" >
		</div>
	</div>
	
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
	<div class="row">
		<div class="col-xs-3"></div>
		<div class="col-xs-3"></div>
	</div><br>
	<div class="row">
		<div class="col-xs-3"></div>
		<div class="col-xs-1">
			<a href="ManageHotels.jsp"><button type="submit" class="btn btn-primary btn-sm">Save</button></a>
		</div>
		<div class="col-xs-1">
			<a href="ManageHotels.jsp"><button type="submit" class="btn btn-primary btn-sm">Cancel</button></a>
		</div>
		<div class="col-xs-7"></div>
	</div><br>
</div>
</body>
</html>