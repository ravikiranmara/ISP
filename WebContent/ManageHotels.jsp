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
<title>Manage Hotels</title>
</head>
<body>

<jsp:include page="headerClient.jsp" />

<%@ page 
import="java.util.ArrayList"
import="modelObject.Hotel"
import="utils.globals"
%>

<%

	ArrayList<Hotel> hotelList = (ArrayList<Hotel>)session.getAttribute(globals.session_hotelsByOwner);
%>


<div class="container">
  <h2>Search Results</h2>
  


  <table class="table">
    <thead>
      <tr>
        <th>Hotel name</th>
        <th>Hotel address</th>
        <th>Description</th>
        <th> Edit </th>
      </tr>
    </thead>
    <tbody>
		<% for(Hotel h : hotelList) {%>
			<tr>
				<td> <%= h.getName() %></td> 
				<td> <%= h.getAddress() %></td> 
				<td> <%= h.getDescription() %></td>
				<td> <a href="EditHotels?id=<%= h.getId() %>">Edit</a> </td>
			</tr> 			
		<% } %>

    </tbody>
  </table>
</div>
</body>
</html>