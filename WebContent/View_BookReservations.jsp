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

<%@ page 
import="java.util.ArrayList"
import="modelObject.Hotel"
import="modelObject.CustomerHotelSearchBean"
import="modelObject.Room"
import="modelObject.Review"
import="utils.globals"
%>

<%

	ArrayList<CustomerHotelSearchBean> results = (ArrayList<CustomerHotelSearchBean>)session.getAttribute(globals.session_customerSearchHotelList);
	CustomerHotelSearchBean bean = null;
	ArrayList<Review> revlist = null;
	
	int id = Integer.valueOf(request.getParameter("id"));
	for(CustomerHotelSearchBean c : results)
	{
		if(c.getHotel().getId() == id)
		{
			bean = c;
		}
	}
	
	revlist = bean.getHotel().getReview();
%>


	<div class="container">
	<div class="row"><br>
	<div> Number of rooms:</div>
	<div class="col-xs-1">
			<div class="dropdown">
				<select name="rooms" class="form-control">
						<option value=1>1</option>
					    <option value=2>2</option>
					    <option value=3>3</option>
					    <option value=4>4</option>
					    <option value=5>5</option>
				</select>
			</div>
		</div>
	</div>
	<div class="col-xs-1">
		<a href="CustomerCreateHotelReservation?id=<%= id%>"><button type="submit" class="btn btn-primary btn-md">Book</button></a>
	</div>
	<div class="col-xs-1">
		<a href="ReservationSearchResults.jsp"><button type="submit" class="btn btn-primary btn-md">Back</button></a>
	</div>
<br>
<br>


	<h3>Hotel: <%= bean.getHotel().getName() %></h3>
	<h3>City: <%= bean.getHotel().getCity() %></h3>
	<h3>Description: <%= bean.getHotel().getDescription() %></h3>        
	<h3>Room type: <%= bean.getRoom().getRoomType() %></h3>        
	<h3>Price per day: <%= bean.getRoom().getPricePerNight() %></h3>
	<h3>Amenities: </h3>
	<h3>Nearest Point:	<%= bean.getHotel().getNearestPoints() %></h3>


<h2>Review List</h2>
  <table class="table">
    <thead>
      <tr>
        <th>Rating</th>
        <th>Reviewer Name</th>
        <th>Date </th>
        <th>Review </th>
      </tr>
    </thead>
    <tbody>
    
    	<% for(Review r : revlist) {%>
			<tr>
				<td><%= r.getRating() %> </td>
				<td><%= r.getReview() %></td>
				<td><%= r.getDate() %></td>
				<td><%= r.getReview() %></td>
			</tr> 			
		<% } %>
		
    </tbody>
  </table>
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