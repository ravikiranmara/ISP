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
<title>Confirm Cancellation</title>
</head>
<body>

<jsp:include page="headerCustomer.jsp" />

<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<center><h3><label>The reservation has been cancelled</label></h3></center>
		</div>
	</div>
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
		<div class="col-xs-3">
			<h5><label>A payement of $45 is credited to:</label></h5>
		</div>
		<div class="col-xs-3">
			<h5><label>First Name</label></h5>
		</div>
		<div class="col-xs-6">
			<h5><label>Last Name</label></h5>
		</div>
	</div>
</div>
</body>
</html>