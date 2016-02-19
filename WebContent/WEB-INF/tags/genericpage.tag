<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>


<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Load Custom Scripts and Styles -->
<link rel="stylesheet" type="text/css" href="css/custom_styles.css">
<link rel="stylesheet" type="text/css" href="css/custom.css">
<title>Edit Hotel Details</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="ClientHomePage.jsp">Hotels.com</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="ClientHomePage.jsp">Home</a></li>
				<li><a href="ManageHotels.jsp">Manage Hotels</a></li>
				<li><a href="ViewCurrentReservations.jsp">View Current
						Reservations</a></li>
				<li><a href="ClientCreateReservation.jsp">Client Create
						Reservation</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="Login.jsp"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</ul>
		</div>
	</nav>
	<div class="container ">
		<jsp:doBody />
	</div>

	<div id="pagefooter">
		<jsp:invoke fragment="footer" />
	</div>
</body>
</html>