<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>SASH - Withdraw Service</title>
  </head>
<body>

	<div class="container-fluid">
	
		<%@ include file = "header.jsp" %>
		
		<div class="jumbotron alert alert-danger">
			<div class="row">
				<!-- Search By Account ID -->
				<div class="col">
					<form method="POST" action="/sash/banking/account/withdraw/search/id">
						<!-- Enter Account ID -->
						<label><b>Enter Account ID :</b></label><br>
	    				<input type="text" name="id" class="form-control"><br>
	  						
	  					<div class="col-sm-10">
	      					<button type="submit" class="btn btn-primary">SEARCH</button>
	    				</div>	
	  				</form>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col">
				<div class="jumbotron alert alert-warning">

					<h2><center>WITHDRAW MONEY</center></h2>
					<hr>
					<form method="POST" action="/sash/banking/account/withdraw">

						<!-- Enter Account ID -->
						<div class="form-group row">
							<label class="col-sm-2 col-form-label"><b>Account ID</b></label>
    						<div class="col-sm-10">${account.accountId }</div>
  						</div>
  						
  						<!-- Enter Account ID -->
						<div class="form-group row">
							<label class="col-sm-2 col-form-label"><b>Account Type</b></label>
    						<div class="col-sm-10">${account.accountType }</div>
  						</div>
  						
  						<!-- Enter Account ID -->
						<div class="form-group row">
							<label class="col-sm-2 col-form-label"><b>Customer ID</b></label>
    						<div class="col-sm-10">${account.customerId.customer_id }</div>
  						</div>
  						
  						<!-- Enter Account ID -->
						<div class="form-group row">
							<label class="col-sm-2 col-form-label"><b>Account Status</b></label>
    						<div class="col-sm-10">${account.status }</div>
  						</div>

						<!-- Enter Amount -->
  						<div class="form-group row">
							<label class="col-sm-2 col-form-label"><b>Enter Amount</b></label>
    						<div class="col-sm-10">
      							<input type="number" name="amount" class="form-control">
    						</div>
  						</div>

						<!-- Enter Message -->
						<div class="form-group row">
							<label class="col-sm-2 col-form-label"><b>Enter Message</b></label>
    						<div class="col-sm-10">
      							<input type="text" name="message" class="form-control">
    						</div>
  						</div>

						<!-- Button to Submit Data -->
						<div class="form-group row">
    						<div class="col-sm-10">
      							<button type="submit" class="btn btn-success">WITHDRAW</button>
    						</div>
 						</div>
					</form>
					<hr>
								
					<!-- Status -->
					<div class="form-group row">
						<label class="col-sm-2 col-form-label"><b>${alert }</b></label>
    				</div>
				</div>
			</div>
		</div>
		
		<%@ include file = "footer.jsp" %>
		
	</div>