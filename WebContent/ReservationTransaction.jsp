<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<!-- Load Custom Scripts and Styles -->
<link rel="stylesheet" type="text/css" href="css/custom_styles.css">
<title>Reservation Transaction</title>
</head>
<body>

<%@ include file="headerCustomer.jsp" %>
<%-- 
<%@ page 
import="java.util.ArrayList"
import="modelObject.CustomerReservationListBean"
import="modelObject.CustomerHotelSearchBean"
import="modelObject.Reservation"
import="modelObject.Transaction"
import="modelObject.User"
import="modelObject.Hotel"
import="modelObject.CreditCard"
import="utils.globals"
%>

<%

	CustomerReservationListBean rbean = (CustomerReservationListBean)session.getAttribute(globals.session_customerReservationBean);
	CustomerHotelSearchBean selectbean = (CustomerHotelSearchBean)session.getAttribute(globals.session_customerSelectBean);
	User customer = (User)session.getAttribute(globals.session_customerReserveTransUser);
	Transaction transaction = rbean.getTransaction();
	ArrayList<CreditCard> cclist = customer.getCreditCard();
	
%>
--%>
<form action="CustomerMakeTransaction" id="confirm-form" name="confirm-form" method="post">
<div class="container ">
	<div class="container ">
	<div class="row">
		<div class="col-xs-2">
			<img src="images/room1.jpg" class="img-rounded" alt="Cinque Terre">
		</div>
		</div>
		<div class="col-xs-2">
			<img src="images/room2.jpg" class="img-rounded" alt="Cinque Terre">
		</div>
		<div class="col-xs-1"></div>
		<div class="col-xs-7">
			<div class="row">
			
				<input type="hidden" id="touserid" name="touserid" value="${sessionScope.session_customerReservationBean.getTransaction().getOwnerUserId()}" />
				<input type="hidden" id="tousercc" name="tousercc" value="${sessionScope.session_customerReservationBean.getTransaction().getOwnerCreditCardId()}" />
				<input type="hidden" id="fromuserid" name="fromuserid" value="${sessionScope.session_customerReservationBean.getTransaction().getCustomerUserId()}" />
				<input type="hidden" id="amount" name="amount" value="${sessionScope.session_customerReservationBean.getTransaction().getAmount()}" />
				
				<div class="col-xs-3">
					<h4><label>Details:</label></h4>
				</div>
				<div class="col-xs-3"></div>
				<div class="col-xs-3"></div>
				<div class="col-xs-3"></div>
			</div>
			<div class="row">
				
				<!--  display table list of transactions here  -->
				
				<div class="col-xs-3">
					<h5><label>total cost: "${sessionScope.session_customerReservationBean.getTransaction().getAmount()}"</label></h5>
				</div>
				<div class="col-xs-3"></div>
			</div>
			<div class="row">
				<div class="col-xs-6">
					<h4><label>Credit Card Information:</label></h4>
				</div>
				<div class="col-xs-6"></div>
			</div>
			<div class="row">
			<div class="col-xs-3">
				Select Customer Credit Card
			</div>
			<div class="col-xs-3">
			<div class="dropdown">
				<select id="fromusercc" name="customercreditcard" class="form-control">
				<%-- 
				<% for(CreditCard c : cclist) {%>
					<option value="<%= c.getId()%>"><%= c.getNickName()%></option>
				<% } %>
				--%>
				<c:forEach items="${sessionScope.session_customerReserveTransUser.getCreditCard()}" var="c">
					<option value="${c.getId()}">${c.getNickName()}</option>
				</c:forEach>
				
				</select>
			</div>		
		</div>
			<div class="row">
				<div class="col-xs-6">
					<h4><label>Credit Card Information:</label></h4>
				</div>
				<div class="col-xs-6"></div>
			</div>
			<div class="row">
				<div class="col-xs-3">
					<h5><label>A/C Holders Name:</label></h5>
				</div>
				<div class="col-xs-3">
					<input type="text" class="form-control" id="firstname" placeholder="First Name">
				</div>
				<div class="col-xs-3">
					<input type="text" class="form-control" id="lastname" placeholder="Last Name">
				</div>
				<div class="col-xs-3"></div>
			</div>
			<div class="row">
				<div class="col-xs-3">
					<h5><label>Card Type:</label></h5>
				</div>
				<div class="col-xs-3">
					<div class="dropdown">
 						<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="cardtype">Card Type
						<span class="caret"></span></button>
						<ul class="dropdown-menu">
							<li><a href="#">master card</a></li>
						    <li><a href="#">visa</a></li>
						    <li><a href="#">discover</a></li>
						</ul>
					</div>		
				</div>
				<div class="col-xs-3"></div>
				<div class="col-xs-3"></div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-2">
			<img src="images/room3.jpg" class="img-rounded" alt="Cinque Terre">
		</div>
		<div class="col-xs-2">
			<img src="images/room4.jpg" class="img-rounded" alt="Cinque Terre">
		</div>
		<div class="col-xs-1"></div>
		<div class="col-xs-7">
			<div class="row">
				<div class="col-xs-3">
					<h5><label>Card Number:</label></h5>
				</div>
				<div class="col-xs-5">
					<input type="text" class="form-control" id="cardnumber" placeholder="Card Number">
				</div>
				<div class="col-xs-2">
					<input type="text" class="form-control" id="cardnumber" placeholder="CVV">
				</div>
				<div class="col-xs-2"></div>
			</div>
			<div class="row">
				<div class="col-xs-3">
					<h5><label>Expiration Date:</label></h5>
				</div>
				<div class="col-xs-2">
					<div class="dropdown">
 						<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="expmonth"> Month
						<span class="caret"></span></button>
						<ul class="dropdown-menu">
							<li><a href="#">JAN</a></li>
						    <li><a href="#">FEB</a></li>
						    <li><a href="#">MAR</a></li>
						    <li><a href="#">APR</a></li>
						    <li><a href="#">MAY</a></li>
						    <li><a href="#">JUN</a></li>
						    <li><a href="#">JUL</a></li>
						    <li><a href="#">AUG</a></li>
						    <li><a href="#">SEP</a></li>
						    <li><a href="#">OCT</a></li>
						    <li><a href="#">NOV</a></li>
						    <li><a href="#">DEC</a></li>
						</ul>
					</div>
				</div>		
				<div class="col-xs-2">
					<div class="dropdown">
 						<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" id="expyear"> Year
						<span class="caret"></span></button>
						<ul class="dropdown-menu">
							<li><a href="#">2016</a></li>
						    <li><a href="#">2017</a></li>
						    <li><a href="#">2018</a></li>
						    <li><a href="#">2019</a></li>
						    <li><a href="#">2020</a></li>
						    <li><a href="#">2021</a></li>
						    <li><a href="#">2022</a></li>
						    <li><a href="#">2023</a></li>
						    <li><a href="#">2024</a></li>
						    <li><a href="#">2025</a></li>
						</ul>
					</div>		
				</div>
				<div class="col-xs-5"></div>
			</div>
			<div class="row">
				<div class="col-xs-3">
					<h5><label>Billing Address:</label></h5>
				</div>
				<div class="col-xs-9">
					<input type="text" class="form-control" id="billingaddr" placeholder="Address1">
				</div>
			</div>
			<div class="row">
				<div class="col-xs-3"></div>
				<div class="col-xs-9">
					<input type="text" class="form-control" id="billingaddr" placeholder="Address2">
				</div>
			</div><br>
			<div class="row">
				<div class="col-xs-6">
					<button onclick="return validate();" type="submit" class="btn btn-primary btn-xs">Confirm Reservation</button>
				</div>
				<div class="col-xs-6">
					<a href="ReservationSearchResults.jsp">Cancel</a>
				</div>
				<div class="col-xs-6"></div>
			</div>
		</div>
		</div>
	</div>
</div>
</form>
</body>

<script type="text/javascript">
	function validate(){
			var touserid = document.getElementById("touserid").value;
			var tousercc = document.getElementById("tousercc").value;
			var fromuserid = document.getElementById("fromuserid").value;
			var fromusercc = document.getElementById("fromusercc").value;
			var amount = document.getElementById("amount").value;
			
			var cartobj = '{'
				+ '"toUserId" : ' + touserid 
				+ ' , "fromUserId" : ' + fromuserid
				+ ' , "toCreditCardId" : ' + tousercc 
				+ ' , "fromCreditCardId" : ' + fromusercc 
				+ ' , "amount" : ' + amount  
				+ '}';
			
			jQuery.support.cors = true;
			//alert(cartobj);
		
			var status = false;		
			$.ajax({
			    type: 'post',
			    url: 'http://localhost:8081/BankTransaction/MakeTransaction',
			    data: cartobj,
			    contentType: "application/json",
			    traditional: true,
			    success: function (data) {
			        alert("Transaction Status : " + data);
			        /*document.getElementById("confirm-form").action = "CustomerMakeTransaction";
					document.forms[0].submit;
					*/
					$.post("CustomerMakeTransaction",
					{
						fromusercc: fromusercc
					},
					function(data,status){
						if(data == "success"){
							window.location.href('ReservationTransactionConfirmation.jsp');
						}
						else
						{
							 window.location.href('CustomerReservationTransactionConfirmationFailed.jsp');
						}
					});
					return true;
			    },
			    error: function (xhr, ajaxOptions, thrownError) {
			        alert(xhr.responseText);
			        alert(thrownError);
			      }
			});
			
			
			return status;
	}; 
</script>


</html>


