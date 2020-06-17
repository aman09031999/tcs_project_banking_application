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

    <title>SASH - DELETE Service</title>
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
						<form method = "POST" action="delete/id">
	
							<div class="alert alert-primary">
								<label for="validationServer01"><h3><b>Personal Information</b></h3></label>
				 				<hr>		
								<div class="row">
				    				
									<table class="table">
										<tbody>
											<tr>
										    	<th scope="row">Customer ID</th>
										      	<td>${customer.customer_id }</td>
										    </tr>
										    <tr>
										      <th scope="row">Customer Name</th>
										      <td>${customer.customer_name }</td>
										    </tr>
										    <tr>
										      <th scope="row">Customer Aadhar No.</th>
										      <td>${customer.aadhar_no }</td>
										    </tr>
										    <tr>
										      <th scope="row">Customer Date of Birth</th>
										      <td>${customer.customer_dob }</td>
										    </tr>
										    <tr>
										      <th scope="row">Customer Age</th>
										      <td>${customer.age }</td>
										    </tr>
										  </tbody>
									</table>
				    				
				  				</div>
								<br>
				  			</div>
			
							<div class="alert alert-warning">
								<label for="validationServer02"><h3><b>Contact Information</h3></b></label>
				 				<hr>
				  				<div class="row">
				    				
				    				<table class="table">
										<tbody>
											<tr>
										    	<th scope="row">Customer Contact No.</th>
										      	<td>${customer.customer_contact1 }</td>
										    </tr>
										    <tr>
										    	<th scope="row">Customer Contact No. (Alternate)</th>
										    	<td>${customer.customer_contact1 }</td>
										    </tr>
										    <tr>
										    	<th scope="row">Customer Email ID.</th>
										    	<td>${customer.customer_email}</td>
										    </tr>
										    <tr>
										      <th scope="row">Customer Address</th>
										      <td>${customer.address_id }</td>
										    </tr>
										  </tbody>
									</table>
				    				
				  				</div>
								<br>
							</div>
  			
  							<div class="alert alert-danger">
								<label for="validationServer03"><h3><b>Account Information</h3></b></label>
								<hr>
								<div class="table-responsive">
		 							<table class="table table-striped table-hover">
		 								<thead>
							    			<tr>
										    	<th scope="col">Account ID</th>
										      	<th scope="col">Customer ID</th>
										      	<th scope="col">Account Type</th>
										      	<th scope="col">Date of Creation</th>
										     	<th scope="col">Account Status</th>
										      	<th scope="col">Available Balance</th>
										      	<th scope="col">message</th>
										      	<th scope="col">Last Operation</th>
										      	<th scope="col">Last Updated</th>
							    			</tr>
							  			</thead>
							  			<tbody>
							    			<c:forEach items="${accounts}" var="obj">
								    		<tr>
										    	<td>${obj.accountId }</td>
										      	<td>${obj.customerId.customer_id }</td>
										     	<td>${obj.accountType }</td>
										      	<td>${obj.doc }</td>
										      	<td>${obj.status }</td>
										      	<td>${obj.amount }</td>
										      	<td>${obj.message }</td>
										      	<td>${obj.last_operation }</td>
										      	<td>${obj.last_updated }</td>
								   			</tr>
							    			</c:forEach>
							  			</tbody>
		  							</table>
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