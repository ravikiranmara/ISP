<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:body>
       <br>
	<div class="row">
		<div class="col-xs-3">
			<h5>
					<label>Hotel Name:</label>
				</h5>
		</div>
		<div class="col-xs-3">
			<input type="text" class="form-control" id="hotelname"
					placeholder="Name">
		</div>
		<div class="col-xs-6"></div>
	</div>
	<div class="row">
		<div class="col-xs-3">
			<h5>
					<label>Description:</label>
				</h5>
		</div>
		<div class="col-xs-9">
			<input type="text" class="form-control" id="Description"
					placeholder="Description">
		</div>
	</div>
	<div class="row">
		<div class="col-xs-3">
			<h5>
					<label>Total no. of rooms:</label>
				</h5>
		</div>
		<div class="col-xs-3">
			<input type="text" class="form-control" id="Description"
					placeholder="Number">
		</div>
		<div class="col-xs-2">
			<h5>
					<label>rooms Types:</label>
				</h5>
		</div>
		<div class="col-xs-4">
			<input type="text" class="form-control" id="Description"
					placeholder="Type">
		</div>
	</div>
	<div class="row">
		<div class="col-xs-3">
			<div class="checkbox">
  				<label><input type="checkbox" value="">Bathtub in room</label>
			</div>
		</div>
		<div class="col-xs-3">
			<div class="checkbox">
  				<label><input type="checkbox" value="">Free breakfast</label>
			</div>
		</div>
		<div class="col-xs-3">
			<div class="checkbox">
  				<label><input type="checkbox" value="">Free Wi-Fi</label>
			</div>
		</div>
		<div class="col-xs-3">
			<div class="checkbox">
  				<label><input type="checkbox" value="">Gym</label>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-3">
			<div class="checkbox">
  				<label><input type="checkbox" value="">Paid Internet access</label>
			</div>
		</div>
		<div class="col-xs-3">
			<div class="checkbox">
  				<label><input type="checkbox" value="">Pool</label>
			</div>
		</div>
		<div class="col-xs-3">
			<div class="checkbox">
  				<label><input type="checkbox" value="">Pet friendly</label>
			</div>
		</div>
		<div class="col-xs-3"></div>
	</div>
	<div class="row">
		<div class="col-xs-3">
			<label>Location city:</label>
		</div>
		<div class="col-xs-3">
			<input type="text" class="form-control" name="city" id="city"
					placeholder="Location city">
		</div>
		<div class="col-xs-3"></div>
		<div class="col-xs-3"></div>
	</div>
		<br>
	<div class="row">
		<div class="col-xs-3">
			<label>Price per day:</label>
		</div>
		<div class="col-xs-3">
			<input type="text" class="form-control" name="city" id="price"
					placeholder="Price per day">
		</div>
		<div class="col-xs-3"></div>
		<div class="col-xs-3"></div>
	</div>
		<br>
	<div class="row">
		<div class="col-xs-3"></div>
		<div class="col-xs-1">
			<a href="ManageHotels.jsp"><button type="submit"
						class="btn btn-primary btn-sm">Save</button></a>
		</div>
		<div class="col-xs-1">
			<a href="ManageHotels.jsp"><button type="submit"
						class="btn btn-primary btn-sm">Cancel</button></a>
		</div>
		<div class="col-xs-7"></div>
	</div>
    </jsp:body>
</t:genericpage>