<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<link rel="stylesheet" type="text/css" src="/css/bootstrap-datepicker.css">
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Load Custom Scripts and Styles -->
<link rel="stylesheet" type="text/css" href="css/custom_styles.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<%
	String username = (String)session.getAttribute("username");
%>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
   		<div class="navbar-header">
     		<a class="navbar-brand" href="#">Hotels.com</a>
    	</div>
   			<ul class="nav navbar-nav">
     			<li class="active"><a href="CustomerHomePage.jsp">Home</a></li>
    			<li><a href="ManageReservationsCustomer">Manage Reservations</a></li>
     	 	</ul>
     	  	<ul class="nav navbar-nav navbar-right">
     			<li class="active"><a href="CustomerShoppingCart.jsp">ShoppingCart</a></li>
    			<li class="active"><a href="#">Hello <%= username %></a></li>
    			<li><a></a></li>
     	 	</ul>
     	 	<ul class="nav navbar-nav navbar-right">
      			<li><a href="${pageContext.request.contextPath}/destroySession"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    		</ul>
	</div>
</nav>
