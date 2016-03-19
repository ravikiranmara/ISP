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
<title>Manage Reservations</title>
</head>
<body>

<jsp:include page="headerCustomer.jsp" />

<%@ page 
import="java.util.ArrayList"
import="modelObject.Reservation"
import="utils.globals"
import="modelObject.ReservationsBean"
import="ModelServiceLayer.HotelService"
import="ModelServiceLayer.IHotelServiceLayer"
%>


<%
	ArrayList<ReservationsBean> rbean = (ArrayList<ReservationsBean>)session.getAttribute(globals.session_customerReservationsList);
%>


<div class="container">
  <h2>Search Results</h2>
  <table class="table">
    <thead>
      <tr>
        <th>Hotel name</th>
        <th>Customer Name</th>
        <th>Room type</th>
        <th>Total rooms</th>
        <th>Total price</th>
        <th>CheckIn Date</th>
        <th>CheckOut Date</th>
      </tr>
    </thead>
    <tbody>

		<% for(ReservationsBean r : rbean) {%>
			<tr>
				<td> <%= r.getHotelName() %> </td>
				<td> <%= r.getUser().getFirstName() %></td>
				<td> <%= r.getRoomType() %></td>
				<td> <%= r.getReservation().getNumberOfRooms() %></td>
				<td> <%= r.getTransaction().getAmount() %></td>
				<td> <%= r.getReservation().getCheckInDate() %> </td>
				<td> <%= r.getReservation().getCheckOutDate() %> </td>
				<td> <a href="CustomerCancelReservationServlet?id=<%= r.getReservation().getId() %>">cancel</a> </td>
			</tr> 			
		<% } %>
		
	</tbody>
  </table>
</div>
</body>
</html>