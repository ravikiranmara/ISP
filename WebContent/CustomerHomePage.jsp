

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
      <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js" type="text/javascript"></script> 
      <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
      <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/base/jquery-ui.css" type="text/css" media="all" />
      <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Customer Home Page</title>
      <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
      <!-- Load Custom Scripts and Styles -->
      <link rel="stylesheet" type="text/css" href="css/custom_styles.css">
      <!-- 
		<script type="text/javascript">
			$(function() {
			    $( "#datepicker1" ).datepicker();
			    $( "#datepicker2" ).datepicker();
			});
		</script>
		 -->
   </head>
   <jsp:include page="headerCustomer.jsp" />
   <form role="form" action= "HotelSearchServlet" method="post">
      <div class="container ">
      <div class="hotelSearchBox">
      <h1>
         <center>Welcome Guests</center>
      </h1>
      <div class="row">
         <div class="col-xs-6">
            <div class="form-group">
               <label for="lbl-hotelName">Hotel Name</label>
               <input type="text" class="form-control" id="hotelName" name="hotelname" placeholder="Hotel Name">
            </div>
            <div class="form-group">
               <label for="lbl-city">City</label>
               <input type="text" class="form-control" name="city" id="city" placeholder="City">
            </div>
            <div class="form-group">
               <label for="lbl-state">State</label>
               <input type="text" class="form-control" name="state" id="state" placeholder="State">
            </div>
            <div class="row">
               <div class="col-xs-6">
                  <div>
                     <label for="checkin">Check-in Date:</label>
                  </div>
                  	<input type="text" id="datepicker1" name="checkIn" />
                  <br>
                  <div>
                     <label for="checkin">Check-out Date:</label>
                  </div>
                  	<input type="text" id="datepicker2" name="checkOut" />
                  <label> Number of Rooms: </label><br>
                  <div class="row">
                     <div class="col-xs-3">
                        <div class="dropdown">
                           <select name="numrooms" id="numrooms">
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
               <div class="col-xs-6">
               </div>
            </div>
            <br>
            <div class="row">
               <div class="col-xs-3">
                  <div class="checkbox">
                     <label><input type="checkbox" name="bathtub" id="amenity" value="">Bathtub in room</label>
                  </div>
               </div>
               <div class="col-xs-3">
                  <div class="checkbox">
                     <label><input type="checkbox" name="breakfast" id="amenity" value="">Free breakfast</label>
                  </div>
               </div>
               <div class="col-xs-3">
                  <div class="checkbox">
                     <label><input type="checkbox" name="wifi" id="amenity" value="">Free Wi-Fi</label>
                  </div>
               </div>
               <div class="col-xs-3">
                  <div class="checkbox">
                     <label><input type="checkbox"  name="gym" id="amenity" value="">Gym</label>
                  </div>
               </div>
            </div>
            <div class="row">
               <div class="col-xs-3">
                  <div class="checkbox">
                     <label><input type="checkbox" name="internet" id="amenity" value="">Paid Internet access</label>
                  </div>
               </div>
               <div class="col-xs-3">
                  <div class="checkbox">
                     <label><input type="checkbox" name="pool" id="amenity" value="">Pool</label>
                  </div>
               </div>
               <div class="col-xs-3">
                  <div class="checkbox">
                     <label><input type="checkbox" name="pet" id="amenity"  value="">Pet friendly</label>
                  </div>
               </div>
               <div class="col-xs-3"></div>
            </div>
         </div>
      </div>
      <div>
         <br>
         <center><button type="submit" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-search"></span>Search</button></center>
      </div>
   </div>
   </div>
   </form>
   </body>
</html>

