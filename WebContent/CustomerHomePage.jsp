<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="headerCustomer.jsp" />



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

<body>
	<form id="searchform" role="search-form" action="HotelSearchServlet"
		method="post">
		<div class="container ">
			<div class="hotelSearchBox">
				<h1>
					<center>Welcome Guests</center>
				</h1>
				<div class="row">
					<div class="col-xs-6">
						<div class="form-group">
							<label for="lbl-hotelName">Hotel Name</label> <input type="text"
								class="form-control" id="hotelName" name="hotelname"
								placeholder="Hotel Name">
						</div>
						<div class="form-group">
							<label for="lbl-city">City</label> <input type="text"
								class="form-control" name="city" id="city" placeholder="City">
						</div>
						<div class="form-group">
							<label for="lbl-state">State</label> <input type="text"
								class="form-control" name="state" id="state" placeholder="State">
						</div>
						<div class="row">
							<div class="col-xs-6">
								<div>
									<label for="checkin">Check-in Date (yyyy-mm-dd):</label>
								</div>
								<input id="datepicker1" type="text" class="form-control"
									name="checkIn"> <br>
								<div>
									<label for="checkin">Check-out Date(yyyy-mm-dd):</label>
								</div>
								<input id="datepicker2" type="text" class="form-control"
									name="checkOut"> 
								<label> Number of Rooms: </label><br>
								<div class="row">
									<div class="col-xs-6">
										<div class="dropdown">
											<select name="numrooms" id="numrooms" class="form-control">
												<option value=1>1</option>
												<option value=2>2</option>
												<option value=3>3</option>
												<option value=4>4</option>
												<option value=5>5</option>
											</select>
										</div>
									</div>
									<div class="dropdown  col-sm-6">
										<select name="roomtype" class="form-control">
											<option value=1>Standard</option>
											<option value=2>Family</option>
											<option value=3>Suite</option>
										</select>
									</div>
									<div class="col-xs-3"></div>
									<div class="col-xs-3"></div>
								</div>
							</div>
							<div class="col-xs-6"></div>
						</div>
						<br>
						<div class="row">
							<div class="col-xs-3">
								<div class="checkbox">
									<label><input type="checkbox" name="bathtub"
										id="amenity" value="">Bathtub in room</label>
								</div>
							</div>
							<div class="col-xs-3">
								<div class="checkbox">
									<label><input type="checkbox" name="breakfast"
										id="amenity" value="">Free breakfast</label>
								</div>
							</div>
							<div class="col-xs-3">
								<div class="checkbox">
									<label><input type="checkbox" name="wifi" id="amenity"
										value="">Free Wi-Fi</label>
								</div>
							</div>
							<div class="col-xs-3">
								<div class="checkbox">
									<label><input type="checkbox" name="gym" id="amenity"
										value="">Gym</label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-3">
								<div class="checkbox">
									<label><input type="checkbox" name="internet"
										id="amenity" value="">Paid Internet access</label>
								</div>
							</div>
							<div class="col-xs-3">
								<div class="checkbox">
									<label><input type="checkbox" name="pool" id="amenity"
										value="">Pool</label>
								</div>
							</div>
							<div class="col-xs-3">
								<div class="checkbox">
									<label><input type="checkbox" name="pet" id="amenity"
										value="">Pet friendly</label>
								</div>
							</div>
							<div class="col-xs-3"></div>
						</div>
					</div>
				</div>
				<div>
					<br>
					<center>
						<button onclick="return validate();" type="submit" class="btn btn-primary btn-lg">
							<span class="glyphicon glyphicon-search"></span>Search</button>
					</center>

				</div>
			</div>
		</div>
	</form>
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
</body>

</html>

