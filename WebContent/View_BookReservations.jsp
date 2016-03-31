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
import="modelObject.Reservation"
import="utils.globals"
%>

<%

	Reservation reservation = (Reservation)session.getAttribute(globals.session_customerReservationObject);
	ArrayList<CustomerHotelSearchBean> results = (ArrayList<CustomerHotelSearchBean>)session.getAttribute(globals.session_customerSearchHotelList);
	int id = Integer.valueOf(request.getParameter("id"));
	CustomerHotelSearchBean bean = null;
	ArrayList<Review> revlist = null;
	
	for(CustomerHotelSearchBean c : results)
	{
		if(c.getHotel().getId() == id)
		{
			bean = c;
		}
	}
	
	revlist = bean.getHotel().getReview();
%>

<!--  <form action="CustomerCreateHotelReservation" method="post"> -->
	<div class="container">
	<div class="row"><br>
	<div> Number of rooms:</div>
	<div class="col-xs-1">
			<div class="dropdown">
				<select name="rooms" id="numrooms" class="form-control" >
						<option selected="selected"><%= reservation.getNumberOfRooms() %></option>
						<option value=1>1</option>
					    <option value=2>2</option>
					    <option value=3>3</option>
					    <option value=4>4</option>
					    <option value=5>5</option>
				</select>
			</div>
			<input type="hidden" id="hotelid" name="hotelid" value="<%= bean.getHotel().getId() %>" />
			<input type="hidden" id="userid" name="userid" value="<%= reservation.getUserId() %>" />
			<input type="hidden" id="roomtypeid" name="roomtypeid" value="<%= reservation.getRoomTypeId() %>" />
			<input type="hidden" id="checkoutdate" name="checkoutdate" value="<%= reservation.getCheckOutDate() %>" />
			<input type="hidden" id="checkindate" name="checkindate" value="<%= reservation.getCheckInDate() %>" />
			<input type="hidden" id="priceperroom" name="priceperroom" value="<%= bean.getRoom().getPricePerNight() %>" />
		</div>
	</div>
	<div class="col-xs-1">
<!-- 		<a href="CustomerCreateHotelReservation"><button onclick="return validate();" type="submit" class="btn btn-primary btn-md">Book</button></a>  -->
			<button id="bookbutton" name="bookbutton" class="btn btn-primary btn-md">Add To Cart</button>
			<button id="bookbutton" name="bookbutton" class="btn btn-primary btn-md">New Search</button>  
	</div>
	<div class="col-xs-1">
		<a href="ReservationSearchResults.jsp"><h4>Back</h4></a>
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
				<td><%= r.getReviewerName() %></td>
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
<!-- </form>  -->
</body>

<script>
$(document).ready(function(){
	$('#bookbutton').click(function(){
		var hotelid = document.getElementById("hotelid").value;
		var numrooms = document.getElementById("numrooms").value;
		var userid = document.getElementById("userid").value;
		var checkoutdate = document.getElementById("checkoutdate").value;
		var checkindate = document.getElementById("checkindate").value;
		var priceperroom = document.getElementById("priceperroom").value;
		var roomtypeid = document.getElementById("roomtypeid").value;
		
		var cartobj = '{'
			+ '"hotelid" : ' + hotelid 
			+ ' , "itemid" : ' + 1 
			+ ' , "numrooms" : ' + numrooms 
			+ ' , "userid" : ' + userid 
			+ ' , "checkOutDate" : "' + checkoutdate 
			+ '" , "checkInDate" : "' + checkindate 
			+ '" , "pricePerRoom" : ' + priceperroom 
			+ ' , "roomTypeId" : ' + roomtypeid 
			+ '}';
		
		//alert (cartobj);
		$.ajax({
		    type: 'post',
		    url: 'ShoppingCartServlet?method=addToCart',
		    data: cartobj,
		    contentType: "application/json",
		    traditional: true,
		    success: function (data) {
		        alert("data posted successfully");
		    },
		    error: function (xhr, ajaxOptions, thrownError) {
		        alert(xhr.responseText);
		        alert(thrownError);
		      }
		});
		
		return true;
	});
}); 
</script>

</html>