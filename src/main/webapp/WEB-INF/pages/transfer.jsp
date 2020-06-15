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

    <title>SASH - Transfer Service</title>
  </head>
<body>

	<div class="container">
		<div class="row">
			<div class="col">
				<div class="jumbotron alert alert-success">

					<h2><center>TRANSFER MONEY</center></h2>
					<hr>
					<form method="POST" action="transfer/account_id">

						<!-- Enter Account ID -->
						<div class="form-group row">
							<label class="col-sm-2 col-form-label"><b>Account ID</b></label>
    						<div class="col-sm-10">${account_id }</div>
  						</div>

						<!-- Enter Amount -->
  						<div class="form-group row">
							<label class="col-sm-2 col-form-label"><b>Enter Amount</b></label>
    						<div class="col-sm-10">
      							<input type="number" name="amount" class="form-control">
    						</div>
  						</div>

						<!-- Select Source Account Type -->
  						<fieldset class="form-group">
						    <div class="row">
						      <legend class="col-form-label col-sm-2 pt-0"><b>Source Account</b></legend>
						      <div class="col-sm-10">
						        <div class="form-check">
						          <input class="form-check-input" type="radio" name="source_account" value="savings" checked>
						          <label class="form-check-label">
						            SAVINGS
						          </label>
						        </div>
						        <div class="form-check">
						          <input class="form-check-input" type="radio" name="source_account" value="current">
						          <label class="form-check-label">
						            CURRENT
						          </label>
						        </div>
						      </div>
						    </div>
						</fieldset>
						
						<!-- Select Destination Account Type -->
  						<fieldset class="form-group">
						    <div class="row">
						      <legend class="col-form-label col-sm-2 pt-0"><b>Destination Account</b></legend>
						      <div class="col-sm-10">
						        <div class="form-check">
						          <input class="form-check-input" type="radio" name="destination_account" value="savings" checked>
						          <label class="form-check-label">
						            SAVINGS
						          </label>
						        </div>
						        <div class="form-check">
						          <input class="form-check-input" type="radio" name="destination_account" value="current">
						          <label class="form-check-label">
						            CURRENT
						          </label>
						        </div>
						      </div>
						    </div>
						</fieldset>

						<!-- Enter Message -->
  						<div class="form-group row">
							<label class="col-sm-2 col-form-label"><b>Enter Message</b></label>
    						<div class="col-sm-10">
      							<input type="text" name="message" class="form-control">
    						</div>
  						</div>
						<div class="form-group row">
    						<div class="col-sm-10">
      							<button type="submit" class="btn btn-primary">TRANSFER</button>
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
</html>