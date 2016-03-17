<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
	String username = (String)session.getAttribute("username");
%>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
   		<div class="navbar-header">
     		<a class="navbar-brand" href="ClientHomePage.jsp">Hotels.com</a>
    	</div>
   			<ul class="nav navbar-nav">
     			<li class="active"><a href="ClientHomePage.jsp">Home</a></li>
    			<li><a href="ManageHotels">Manage Hotels</a></li>
    			<li><a href="ClientCurrentReservation">View Current Reservations</a></li>
    			<li><a href="ClientCreateReservation.jsp">Client Create Reservation</a></li>
     	 	</ul>
     	 	<ul class="nav navbar-nav navbar-right">
     			<li class="active"><a href="#">Hello <%= username %></a></li>
    			<li><a><</a></li>
     	 	</ul>
     	 	<ul class="nav navbar-nav navbar-right">
      			<li><a href="${pageContext.request.contextPath}/destroySession"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    		</ul>
	</div>
</nav>
</html>