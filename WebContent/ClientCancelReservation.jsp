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

<jsp:include page="headerClient.jsp" />

<%-- 
<%@ page 
import="java.util.ArrayList"
import="modelObject.Reservation"
import="utils.globals"
import="modelObject.ReservationsBean"
import="ModelServiceLayer.HotelService"
import="ModelServiceLayer.IHotelServiceLayer"
%>


<%
	ReservationsBean rbean = (ReservationsBean)session.getAttribute(globals.session_clientCancelBean);
%>
--%>

<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<center><h3><label>The reservation will be cancelled</label></h3></center>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-3"></div>
		<div class="col-xs-3">
			<h5><label>Hotel: ${sessionScope.session_clientCancelBean.getHotelName()}</label></h5>
		</div>
		<div class="col-xs-3">
			<h5><label>Room type: ${sessionScope.session_clientCancelBean.getRoomType()}</label></h5>
		</div>
		<div class="col-xs-3">
			<h5><label>Number of Rooms : ${sessionScope.session_clientCancelBean.getReservation().getNumberOfRooms() }</label></h5>
			<h5><label>Hotel: ${sessionScope.globals.session_clientCancelBean.getHotelName() }</label></h5>
			<h5><label>Hotel: ${sessionScope.session_clientCancelBean.getHotelName()}</label></h5>
		</div>
		<div class="col-xs-3">
			<h5><label>Room type: ${sessionScope.session_clientCancelBean.getRoomType()}</label></h5>
		</div>
		<div class="col-xs-3">
			<h5><label>Number of Rooms : ${sessionScope.session_clientCancelBean.getReservation().getNumberOfRooms() }</label></h5>
			<h5><label>Hotel: ${sessionScope.globals.session_clientCancelBean.getHotelName() }</label></h5>
		</div>
		<div class="col-xs-3">
			<h5><label>Room type: ${sessionScope.globals.session_clientCancelBean.getRoomType()}</label></h5>
		</div>
		<div class="col-xs-3">
			<h5><label>Number of Rooms : ${sessionScope.globals.session_clientCancelBean.getReservation().getNumberOfRooms() }</label></h5>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-3"></div>
		<div class="col-xs-3">
			<h5><label>Reservation Number: ${sessionScope.session_clientCancelBean.getReservation().getReservationNumber()}</label></h5>
		</div>
		<div class="col-xs-3">
			<h5><label>Amount to refund: ${sessionScope.session_clientCancelBean.getTransaction().getAmount()}</label></h5>
			<h5><label>Reservation Number: ${sessionScope.globals.session_clientCancelBean.getReservation().getReservationNumber()}</label></h5>
		</div>
		<div class="col-xs-3">
			<h5><label>Amount to refund: ${sessionScope.globals.session_clientCancelBean.getTransaction().getAmount()}</label></h5>
		</div>
	</div>
	<div class="row">
				<div class="col-xs-2">
					<a href="ClientCancelReservationAndRefund"><button type="submit" class="btn btn-primary btn-sm">Confirm Cancellation</button></a>
				</div>
				<div class="col-xs-2">
					<a href="ClientHomePage.jsp"><button type="submit" class="btn btn-primary btn-sm">Cancel</button></a>
				</div>
				<div class="col-xs-8"></div>
	</div><br>
</div>
</body>
</html>
