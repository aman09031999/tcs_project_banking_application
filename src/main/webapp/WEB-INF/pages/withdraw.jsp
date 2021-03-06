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

	<div class="container">
		
		<div class="row">
			<div class="col col-6">
				<label class="col-sm-2"><strong>Date & Time :</strong></label>
    			<div class="col-sm-10"><%= (new java.util.Date()).toLocaleString()%></div>
			</div>
			<div class="col col-6">
				<label class="col-sm-2"><strong>Date & Time :</strong></label>
    			<div class="col-sm-10"><%= (new java.util.Date()).toLocaleString()%></div>
			</div>
		</div>

		<div class="row">
			<div class="col">
				<div class="jumbotron alert alert-success">

					<h2><center>WITHDRAW MONEY</center></h2>
					<hr>
					<form method="POST" action="withdraw/withdraw_service">

						<!-- Enter Account ID -->
						<div class="form-group row">
							<label class="col-sm-2 col-form-label"><b>Enter Account ID</b></label>
    						<div class="col-sm-10">${account_id }</div>
  						</div>

						<!-- Enter Amount -->
  						<div class="form-group row">
							<label class="col-sm-2 col-form-label"><b>Enter Amount</b></label>
    						<div class="col-sm-10">
      							<input type="number" name="amount" class="form-control">
    						</div>
  						</div>

						<!-- Select Account Type -->
  						<fieldset class="form-group">
						    <div class="row">
						      <legend class="col-form-label col-sm-2 pt-0"><b>Account Type</b></legend>
						      <div class="col-sm-10">
						        <div class="form-check">
						          <input class="form-check-input" type="radio" name="account_type" id="gridRadios1" value="savings" checked>
						          <label class="form-check-label" for="gridRadios1">
						            SAVINGS
						          </label>
						        </div>
						        <div class="form-check">
						          <input class="form-check-input" type="radio" name="account_type" value="current">
						          <label class="form-check-label" for="gridRadios2">
						            CURRENT
						          </label>
						        </div>
						      </div>
						    </div>
						</fieldset>

						<div class="form-group row">
    						<div class="col-sm-10">
      							<button type="submit" class="btn btn-primary">WITHDRAW</button>
    						</div>
 						</div>
					</form>
					
					<hr>
					<strong>STATUS :</strong> ${status }
				</div>
			</div>
		</div>
	</div>

</body>
</html>