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
						<center><img src="img/businessmen.png" alt="..." width="200" height="200" class="rounded-lg"><br><br><h3>ADMIN DETAILS</h3><hr></center>
					</div>	
				</div>

				<div class="col-9">

					<br>
						<center><h2><b>CUSTOMER REGISTRATION FORM</b></h2></center>
					<hr>
					<br>
						<form method = "POST" action="/sash/banking/account/create/id">
	
							<div class="alert alert-primary">
								<label for="validationServer01"><h3><b>Personal Information</b></h3></label>
				 				<hr>		
								<div class="row">
				    				
				    				<div class="col">
				      					<label for="validationServer01"><b>Customer ID</b></label><br>${id }
				    				</div>
				    				
				    				<div class="col">
				    					<!-- Select Source Account Type -->
				  						<fieldset class="form-group">
										    <div class="row">
										      <legend class="col-form-label col-sm-2 pt-0"><b>Select Account Type</b></legend>
										      <div class="col-sm-10">
										        <div class="form-check">
										          <input class="form-check-input" type="radio" name="type" value="savings" checked>
										          <label class="form-check-label">
										            SAVINGS
										          </label>
										        </div>
										        <div class="form-check">
										          <input class="form-check-input" type="radio" name="type" value="current">
										          <label class="form-check-label">
										            CURRENT
										          </label>
										        </div>
										      </div>
										    </div>
										</fieldset>
				    				</div>
				    				
				    				<div class="col">
				    					<label for="validationServer01"><b>Enter Base Amount</b></label><br>
				      					<input type="number" class="form-control" required="required" pattern="[0-9]?" name="amount">
				    				</div>
				    				
				  				</div>
								<br>
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
