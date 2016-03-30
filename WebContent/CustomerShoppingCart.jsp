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


<div class="container">
  <h2>Items in Shopping Cart</h2>
  <table class="table" id="carttable">
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

    <tbody id="tbody">
	</tbody>

  </table>
</div>
</body>

<script>
	$(document).ready(function(){
	$.ajax({ 
	    url: 'ShoppingCartServlet?method=getAllItemsInCart',
		type: 'post',
		success: function(data){
			displayTable(data);
		},
		error: function(data){
			alert ("error : " + JSON.stringify(data));	
		}});
	});
	
	function displayTable(data)
	{
		var cartitems = data.cart;
		var length = cartitems.length;
		
		for(var i=0; i<length; i++)
		{
			var cartitem = cartitems[i];
			
			var tr = "<tr>";
			var hotelid = "<td>" + cartitem.hotelid + "</td>";
			var userid = "<td>" + cartitem.userid + "</td>";
			var numrooms = "<td>" + cartitem.numrooms + "</td>";
			var checkoutdate = "<td>" + cartitem.checkOutDate + "</td>";
			var checkindate = "<td>" + cartitem.checkInDate + "</td>";
			var roomtypeid = "<td>" + cartitem.roomTypeId + "</td>";
			var priceperroom = "<td>" + cartitem.pricePerRoom + "</td>";
			var trend = "</tr>";
			
			$("#tbody").append(tr + hotelid + userid +
					roomtypeid + numrooms + 
					checkindate + checkoutdate + 
					priceperroom + trend); 
		}
		
		alert(result.itemid);
           alert("success" + JSON.stringify(data));
	}
</script>

</html>