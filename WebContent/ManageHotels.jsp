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

<div class="container">
  <h2>Search Results</h2>
  <table class="table">
    <thead>
      <tr>
        <th>Hotel name</th>
        <th>Hotel address</th>
        <th>Description</th>
        <th>Room type</th>
        <th>Price per night</th>
        <th>Reserved rooms</th>
        <th>Unreserved rooms</th>
        <th>Edit</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>Trump</td>
        <td>Las Vegas</td>
        <td>The luxurious and exclusive Trump International Hotel & Tower New York is set in the heart of Manhattan, on the Upper West Side, at the junction of Central Park West and Broadway. Central Park is just across the street</td>
        <td>Standard</td>
        <td>$35</td>
        <td>30</td>
        <td>40</td>
        <td><a href="EditHotelDetails.jsp"><button type="submit" class="btn btn-primary btn-sm">Edit</button></a></td>
      </tr>
      <tr>
        <td>Excalibur</td>
        <td>New York</td>
        <td>The luxurious and exclusive Trump International Hotel & Tower New York is set in the heart of Manhattan, on the Upper West Side, at the junction of Central Park West and Broadway. Central Park is just across the street</td>
        <td>Family</td>
        <td>$45</td>
        <td>30</td>
        <td>40</td>
       	<td><a href="EditHotelDetails.jsp"><button type="submit" class="btn btn-primary btn-sm">Edit</button></a></td>
      </tr>
      <tr>
        <td>Bellagio</td>
        <td>Las Vegas</td>
        <td>The luxurious and exclusive Trump International Hotel & Tower New York is set in the heart of Manhattan, on the Upper West Side, at the junction of Central Park West and Broadway. Central Park is just across the street</td>
        <td>Suite</td>
        <td>$60</td>
        <td>30</td>
        <td>40</td>
        <td><a href="EditHotelDetails.jsp"><button type="submit" class="btn btn-primary btn-sm">Edit</button></a></td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>