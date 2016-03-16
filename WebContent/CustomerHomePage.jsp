

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
      <title>Customer Home Page</title>
      <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
      <!-- Load Custom Scripts and Styles -->
      <link rel="stylesheet" type="text/css" href="css/bootstrap-datepicker.css">
      <link rel="stylesheet" type="text/css" href="css/custom_styles.css">
   </head>
   <jsp:include page="headerCustomer.jsp" />
   <form role="form" action= "ReservationSearchResults.jsp">
      <div class="container ">
      <div class="hotelSearchBox">
      <h1>
         <center>Welcome Guests</center>
      </h1>
      <div class="row">
         <div class="col-xs-6">
            <div class="form-group">
               <label for="lbl-hotelName">Hotel Name</label>
               <input type="text" class="form-control" id="hotelName" name="hotelNmae" placeholder="Hotel Name">
            </div>
            <div class="form-group">
               <label for="lbl-city">City</label>
               <input type="text" class="form-control" id="city" placeholder="City">
            </div>
            <div class="form-group">
               <label for="lbl-state">State</label>
               <input type="text" class="form-control" id="state" placeholder="State">
            </div>
            <div class="row">
               <div class="col-xs-6">
                  <div>
                     <label for="checkin">Check-in Date:</label>
                  </div>
                  <div class="input-group date" data-provide="datepicker">
                     <input type="text" id="checkin-date" name="checkin-date" class="form-control">
                     <div class="input-group-addon">
                        <span class="glyphicon glyphicon-th"></span>
                     </div>
                  </div>
                  <br>
                  <div>
                     <label for="checkin">Check-out Date:</label>
                  </div>
                  <div class="input-group date" data-provide="datepicker">
                     <input type="text" id="checkin-date" name="checkin-date" class="form-control">
                     <div class="input-group-addon">
                        <span class="glyphicon glyphicon-th"></span>
                     </div>
                  </div>
                  <label> Number of: </label><br>
                  <div class="row">
                     <div class="col-xs-3">
                        <div class="dropdown">
                           <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" name="numroom" id="numroom">Rooms
                           <span class="caret"></span></button>
                           <ul class="dropdown-menu">
                              <li><a href="#">1</a></li>
                              <li><a href="#">2</a></li>
                              <li><a href="#">3</a></li>
                              <li><a href="#">4</a></li>
                              <li><a href="#">5</a></li>
                              <li><a href="#">6</a></li>
                              <li><a href="#">7</a></li>
                              <li><a href="#">8</a></li>
                              <li><a href="#">9</a></li>
                              <li><a href="#">10</a></li>
                           </ul>
                        </div>
                     </div>
                     <div class="col-xs-3">
                        <div class="dropdown">
                           <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" name="roomtype" id="roomtype">Type
                           <span class="caret"></span></button>
                           <ul class="dropdown-menu">
                              <li><a href="#">Standard</a></li>
                              <li><a href="#">Family</a></li>
                              <li><a href="#">Suite</a></li>
                           </ul>
                        </div>
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
                     <label><input type="checkbox" name="amenity" id="amenity" value="">Bathtub in room</label>
                  </div>
               </div>
               <div class="col-xs-3">
                  <div class="checkbox">
                     <label><input type="checkbox" name="amenity" id="amenity" value="">Free breakfast</label>
                  </div>
               </div>
               <div class="col-xs-3">
                  <div class="checkbox">
                     <label><input type="checkbox" name="amenity" id="amenity" value="">Free Wi-Fi</label>
                  </div>
               </div>
               <div class="col-xs-3">
                  <div class="checkbox">
                     <label><input type="checkbox"  name="amenity" id="amenity" value="">Gym</label>
                  </div>
               </div>
            </div>
            <div class="row">
               <div class="col-xs-3">
                  <div class="checkbox">
                     <label><input type="checkbox" name="amenity" id="amenity" value="">Paid Internet access</label>
                  </div>
               </div>
               <div class="col-xs-3">
                  <div class="checkbox">
                     <label><input type="checkbox" name="amenity" id="amenity" value="">Pool</label>
                  </div>
               </div>
               <div class="col-xs-3">
                  <div class="checkbox">
                     <label><input type="checkbox" name="amenity" id="amenity"  value="">Pet friendly</label>
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

