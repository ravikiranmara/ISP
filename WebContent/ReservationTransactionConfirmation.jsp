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
<title>Reservation Transaction Confirmation</title>
</head>
<body>

<%@ page 
import="java.util.ArrayList"
import="modelObject.Reservation"
import="modelObject.Transaction"
import="modelObject.User"
import="modelObject.Hotel"
import="modelObject.CreditCard"
import="utils.globals"
import="modelObject.Room"
%>

<%

	Transaction transaction = (Transaction)session.getAttribute(globals.session_clientResTrans);
	Reservation reservation = (Reservation)session.getAttribute(globals.session_clientres);
	User customer = (User)session.getAttribute(globals.session_clientResCust);
	User owner = (User)session.getAttribute(globals.session_clientResCli);
	Hotel hotel = (Hotel)session.getAttribute(globals.session_clientResHotelname);
	Room room = (Room)session.getAttribute(globals.session_clientResRoom);
	CreditCard cc = (CreditCard)session.getAttribute(globals.session_clientResCustCC);
	
%>

<jsp:include page="headerCustomer.jsp" />

<div class="container ">
	<dev class="row">
		<div class="col-xs-12">
			<center><h3>Reservation Confirmation</h3></center>
		</div>
	</dev>
	<div class="row">
		<div class="col-xs-3"></div>
		<div class="col-xs-3">
			<h5><label>Hotel: <%= hotel.getName() %></label></h5>
		</div>
		<div class="col-xs-3">
			<h5><label>Room type: <%= room.getRoomType() %></label></h5>
		</div>
		<div class="col-xs-3">
			<h5><label>Total cost: <%= transaction.getAmount() %></label></h5>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-3">
			<h5><label>A/C Holders Name: <%= cc.getHolderName() %></label></h5>
		</div>
		<div class="col-xs-3"></div>
	</div>
	<div class="row">
		<div class="col-xs-3">
			<h5><label>Card Type: <%= cc.getNickName() %> </label></h5>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-3">
			<h5><label>Customer Name : <%= customer.getFirstName() %></label></h5>
		</div>
		</div>
	<div class="row">
		<div class="col-xs-3"></div>
		<h5><label>Reservation Number : <%= reservation.getReservationNumber() %></label></h5>
	</div><br>
	<div class="row">
		<div class="col-xs-12">
			<center><h3><label>Your reservation has been confirmed</label></h3></center>
		</div>
	</div>
</div>
</body>
</html>