<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file ="headerClient.jsp" %>

<title>Client Create Reservation</title>
<%-- 
<%@ page 
import="java.util.ArrayList"
import="modelObject.Hotel"
import="utils.globals"
%>

<%

	ArrayList<Hotel> hotelList = (ArrayList<Hotel>)session.getAttribute(globals.session_CreateReshotelsByOwner);
%>
--%>
</head>
<body>

	 
<script type="text/javascript">
	function validate() {

		var a = document.getElementById("datepicker1").value;
		var b = document.getElementById("datepicker2").value;
		console.log(a, b);
		if (a && b) {
			var from = a.split("/");
			var f = new Date(from[1] - 1, from[2], from[0]);

			var to = b.split("/");
			var t = new Date(to[1] - 1, to[2], to[0]);

			if (f >= t) {
				alert("Checkin date is after checkout date");
				return false;
			}

			document.getElementById("searchform").action = "HotelSearchServlet";
			document.getElementById("searchform").submit();

			return true;
		} else {
			alert("Enter Checkin and checkout dates");
			return false;
		}
	}
</script>


<form action="ClientCreateReservation" method="post">
<div class="container ">
	<br>
	<div class="row">
		<div class="col-xs-3">
			<h5><label>Select Hotel:</label></h5>
		</div>
		<div class="col-xs-3">
			<div class="dropdown">
		
				<select name="HotelName" class="form-control">
				<%--
				<% for(Hotel h : hotelList) {%>
					<option value="<%= h.getId()%>"><%= h.getName() %></option>
				<% } %>
				 --%>
				 <c:forEach items="${sessionScope.session_CreateReshotelsByOwner}" var="h">
				 	<option value="${h.getId()}">${h.getName()}</option>
				 </c:forEach>
				</select>
		
			</div>		
		</div>
		<div class="col-xs-3">
			<h5><label>Number of Rooms:</label></h5>
		</div>
		<div class="col-xs-3">
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
	</div><br>
	<div class="row">
		<div class="col-xs-3">
			<label for="checkin">Check-in Date(YYYY-MM-DD):</label>
        </div>
        <div class="col-xs-3">
          	<input type="text" id="datepicker1" name="checkIn" placeholder="yyyy-mm-dd"/>
        </div>
        <div class="col-xs-3">
            <label for="checkin">Check-out Date(YYYY-MM-DD):</label>
        </div>
        <div class="col-xs-3">
           	<input type="text" id="datepicker2" name="checkOut" placeholder="yyyy-mm-dd"/>
        </div>
	</div><br>
	<div class="row">
		<div class="col-xs-2">
			<h5><label>Room type:</label></h5>
		</div>
		<div class="col-xs-3">
			<div class="dropdown">
				<select name="roomType" class="form-control">
						<option value=1>Standard</option>
					    <option value =2>Family</option>
					    <option value=3>Suite</option>
				</select>
			</div>
		</div>
	</div><br>	
	<div class="row">
		<div class="col-xs-2">
			<label>Name:</label>
		</div>
		<div class="col-xs-4">
			<input type="text" class="form-control" name="firstname" id="firstname" placeholder="First Name">
		</div>
		<div class="col-xs-4">
			<input type="text" class="form-control" name="lastname" id="lastname" placeholder="Last Name">
		</div>
		<br>		
	</div><br>
	<div class = "row">
		<div class="col-xs-2">
			<label>Customer Username:</label>
		</div>
		<div class="col-xs-2"></div>
			<div class="col-xs-2">
			<input type="text" id="username" name="username" placeholder="username"/>
		</div>
	
	</div>
	<div class="row">
		<div class="col-xs-2">
			<label>Phone No.</label>
		</div>
		<div class="col-xs-2">
			<input type="text" class="form-control" name="phoneno" id="city" placeholder="Phone No.">
		</div>
		<div class="col-xs-8"></div>
	</div><br>	
	<div class="row">
		<div class="col-xs-2">
			<label>Email:</label>
		</div>
		<div class="col-xs-3">
			<input type="text" class="form-control" name="email" id="city" placeholder="Email">
		</div>
		<div class="col-xs-7"></div>
	</div><br>
	<div class="row">
		<center><button onclick="return validate();"  type="submit" class="btn btn-primary btn-md">Submit</button></center>
	</div><br>
</div>
</form>
</body>
<script>
	
	  $(function() {
		  $("#datepicker1").datepicker();
			format: 'yyyy-mm-dd';
	  });
		
	  $(function() {
		  $("#datepicker2").datepicker();
			format: 'yyyy-mm-dd';
	  });
	</script>


</html>