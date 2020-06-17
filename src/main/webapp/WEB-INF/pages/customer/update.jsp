<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>SASH - UPDATE Service</title>
  </head>
<body>

		<div class="container-fluid">
		
		<%@ include file = "header.jsp" %>
				
		<!------------------------------------------------------| Body Content |--------------------------------------------------------------->	
		<div class="row">
				<div class="col-3">
					<div class="jumbotron bg-danger">
						<center><img src="img/businessmen.png" alt="..." width="200" height="200" class="rounded-lg"><br><br><h3>ADMIN DETAILS</h3><hr></center>
					</div>	
				</div>

				<div class="col-9">

					<br>
						<center><h2><b>CUSTOMER Information</b></h2></center>
					<hr>
					<br>
						<form method = "POST" action="/sash/customer/update/search/id">
	
							<div class="alert alert-primary">
								<label for="validationServer01"><h3><b>Personal Information</b></h3></label>
				 				<hr>		
								<div class="row">
				    				<div class="col col-lg-4">						      
				      					<label for="validationServer01"><b>Customer name</b></label><br>
				      					<input type="text" name="customer_name" class="form-control" value="${customer.customer_name }" placeholder="enter cutsomer name">
				    				</div>
				    				<div class="col col-lg-4">
				    					<label for="validationServer01"><b>Aadhar Number</b></label><br>
				      					<input type="number" name="aadhar_no" class="form-control" value="${customer.aadhar_no }" pattern="[0-9]{12}?" placeholder="enter aadhar card no.">
				    				</div>
				    				
				    				<div class="col col-lg-4">
				    					<label for="validationServer01"><b>Date of Birth</b></label><br>
				      					<input type="date" class="form-control" value="${customer.dob }" name="dob">
				    				</div>

				  				</div>
								<br>
				  			</div>
			
							<div class="alert alert-warning">
								<label for="validationServer02"><h3><b>Contact Information</h3></b></label>
				 				<hr>
				  				<div class="row">
				    				<div class="col">
				      					<label for="validationServer02"><b>Email ID</b></label><br>
				      					<input type="email" name="email" class="form-control" value="${customer.customer_email }" title="Must contain email format"/>
				    				</div>
				
				    				<div class="col">
				    					<label for="validationServer02"><b>Contact no.</b></label><br>
				      					<input type="text" name="contact1" class="form-control" value="${customer.customer_contact1 }" pattern="[0-9]{10}?" title ="Must contain 10 digit Phone number" />
				    				</div>
				
				    				<div class="col">
				    					<label for="validationServer02"><b>Enter Contact no. (Alternative)</b></label><br>
				      					<input type="text" name="contact2" class="form-control" value="${customer.customer_contact2 }" pattern="[0-9]{10}?" title ="Must contain 10 digit Phone number" />
				    				</div>
				  				</div>
								<br>
							</div>
  			
  							<div class="alert alert-danger">
								<label for="validationServer03"><h3><b>Address Information</h3></b></label>
								<hr>
				  				<div class="row">
				    				<div class="col">
				      					<label for="validationServer03"><b>Flat no./Plot No.</b></label>
				      					<input type="text" name="plot" class="form-control" value="${customer.address.plot} " placeholder="Enter flat no./Plot no.">
				    				</div>
				
				    				<div class="col">
				    					<label for="validationServer03"><b>Area</b></label>
				      					<input type="text" name="area" class="form-control" value="${customer.address.area} " placeholder="Enter locality">
				    				</div>
				
				    				<div class="col">
				    					<label for="validationServer03"><b>Enter District</b></label>
				      					<input type="text" name="district" class="form-control" value="${customer.address.district}" placeholder="Enter city">
				    				</div>
				  				</div>
				  				<br>
				  				<div class="row">
				    				
				    				<div class="col">
				      					<label for="validationServer01"><b>Enter State</b></label>
				      					<input type="text" name="state" class="form-control" value="${customer.address.state} " placeholder="Enter state">
				    				</div>
				
				    				<div class="col">
				    					<label for="validationServer01"><b>Enter Zip Code</b></label>
				      					<input type="number" name="pincode" class="form-control" value="${customer.address.pincode} " placeholder="Enter zip">
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