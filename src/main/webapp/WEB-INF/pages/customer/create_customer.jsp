<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    
<title>SASH - CREATE CUSTOMER</title>
</head>
<body>

	<div class="container-fluid">
		
		<%@ include file = "header.jsp" %>
				
		<!------------------------------------------------------| Body Content |--------------------------------------------------------------->	
		<div class="row">
				<div class="col-3">
					<div class="jumbotron bg-danger">
						<center>
								<img src="img/businessmen.png" alt="..." width="200" height="200" class="rounded-lg">
								<br>
								<br>
								<h3>ADMIN DETAILS</h3>
								<hr>
						</center>
					</div>	
				</div>

				<div class="col-9">

					<br>
						<center><h2><b>CUSTOMER REGISTRATION FORM</b></h2></center>
					<hr>
					<br>
						<form method = "POST" action="/sash/customer/create/id">
	
							<div class="alert alert-primary">
								<label for="validationServer01"><h3><b>Personal Information</b></h3></label>
				 				<hr>		
								<div class="row">
				    				<div class="col">
				      					<label for="validationServer01"><b>Enter Customer name</b></label><br>
				      					<input type="text" name="customer_name" class="form-control" required="required" placeholder="enter cutsomer name">
				    				</div>
				    				<div class="col">
				    					<label for="validationServer01"><b>Enter Aadhar Number</b></label><br>
				      					<input type="number" name="aadhar_no" class="form-control" required="required" pattern="[0-9]{12}?" placeholder="enter aadhar card no.">
				    				</div>
				    				
				    				<div class="col">
				    					<label for="validationServer01"><b>Enter Date of Birth</b></label><br>
				      					<input type="date" class="form-control" required="required" name="dob">
				    				</div>
				    				
				  				</div>
								<br>
				  			</div>
			
							<div class="alert alert-warning">
								<label for="validationServer02"><h3><b>Contact Information</h3></b></label>
				 				<hr>
				  				<div class="row">
				    				<div class="col">
				      					<label for="validationServer02"><b>Enter Email ID</b></label><br>
				      					<input type="email" name="email" class="form-control" required="required" title="Must contain email format"/>
				    				</div>
				
				    				<div class="col">
				    					<label for="validationServer02"><b>Enter Contact no.</b></label><br>
				      					<input type="text" name="contact1" class="form-control" required="required" pattern="[0-9]{10}?" title ="Must contain 10 digit Phone number" />
				    				</div>
				
				    				<div class="col">
				    					<label for="validationServer02"><b>Enter Contact no. (Alternative)</b></label><br>
				      					<input type="text" name="contact2" class="form-control" required="required" pattern="[0-9]{10}?" title ="Must contain 10 digit Phone number" />
				    				</div>
				  				</div>
								<br>
							</div>
  			
  							<div class="alert alert-danger">
								<label for="validationServer03"><h3><b>Address Information</h3></b></label>
								<hr>
				  				<div class="row">
				    				<div class="col">
				      					<label for="validationServer03"><b>Enter Flat no./Plot No.</b></label>
				      					<input type="text" name="plot" class="form-control" placeholder="Enter flat no./Plot no.">
				    				</div>
				
				    				<div class="col">
				    					<label for="validationServer03"><b>Enter Area</b></label>
				      					<input type="text" name="area" class="form-control" placeholder="Enter locality">
				    				</div>
				
				    				<div class="col">
				    					<label for="validationServer03"><b>Enter District</b></label>
				      					<input type="text" name="district" class="form-control" placeholder="Enter city">
				    				</div>
				  				</div>
				  				<br>
				  				<div class="row">
				  				
				  					<div class="col">
				    					<label for="validationServer03"><b>Enter City</b></label>
				      					<input type="text" name="city" class="form-control" placeholder="Enter city">
				    				</div>
				    				
				    				<div class="col">
				      					<label for="validationServer01"><b>Enter State</b></label>
				      					<input type="text" name="state" class="form-control" placeholder="Enter state">
				    				</div>
				
				    				<div class="col">
				    					<label for="validationServer01"><b>Enter Zip Code</b></label>
				      					<input type="text" name="pincode" class="form-control" placeholder="Enter zip">
				    				</div>
				  				</div>
							</div>
							<br>
				  			<div class="alert alert-success">
								<label for="validationServer03"><h3><b>Enter MESSAGE</h3></b></label>
								<hr>
				  				<div class="row">
				    				<div class="col">
				      					<input type="text" name="message" class="form-control" placeholder="Enter message">
				    				</div>
				    			</div>
				    		</div>							
							<br>
  							<center><button class="btn btn-secondary btn-lg btn-success" type="submit">SUBMIT</button></center>
							<br>
						</form>
				</div>
		</div>	
	</div>

	<%@ include file = "footer.jsp" %>
