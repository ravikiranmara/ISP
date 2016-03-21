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
<%@ page errorPage="CustomerGenericErrorPage.jsp" %>
<jsp:include page="headerCustomer.jsp" />


<%@ page 
import="java.util.ArrayList"
import="modelObject.Hotel"
import="modelObject.CustomerHotelSearchBean"
import="modelObject.Room"
import="utils.globals"
%>

<%
	ArrayList<CustomerHotelSearchBean> results = (ArrayList<CustomerHotelSearchBean>)session.getAttribute(globals.session_customerSearchHotelList);
%>

<form action="View_BookReservations.jsp" method="post" >
  <div class="container">
  <h2>Search Results</h2>
  <table class="table">
    <thead>
      <tr>
        <th>Hotel name</th>
        <th>Hotel address</th>
        <th>Hotel description</th>
        <th>Room type</th>
        <th>Price per night</th>
        <th>View/Book</th>
      </tr>
    </thead>
    <tbody>
    
    	<% for(CustomerHotelSearchBean r : results) {%>
			<tr>
				<td style="display:none;"><%= r.getHotel().getId() %></td>
				<td><%= r.getHotel().getName()	%> </td>
				<td><%= r.getHotel().getAddress() %></td>
				<td><%= r.getHotel().getDescription() %></td>
				<td><%= r.getRoom().getRoomType() %></td>
				<td><%= r.getRoom().getPricePerNight() %></td>
				<td><button type="submit" name="id" value="<%= r.getHotel().getId() %>" id="book"> View And Book </button> </td>
			</tr> 			
		<% } %>
		
    </tbody>
  </table>
</div>
</form>
</body>
</html>