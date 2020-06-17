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

    <title>SASH - Search Service</title>
  </head>
<body>

	<div class="container-fluid">

		<%@ include file = "header.jsp" %>
		
		<div class="jumbotron alert alert-danger">
			<div class="row">
				<!-- Search By Account ID -->
				<div class="col">
					<form method="POST" action="id">
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
		
		<div class="jumbotron alert alert-primary">
			<div class="table-responsive">
 				<table class="table table-striped table-hover">
 					<thead>
					    <tr>
					      <th scope="col">Account ID</th>
					      <th scope="col">Customer Name</th>
					      <th scope="col">Account Type</th>
					      <th scope="col">Account Status</th>
					      <th scope="col">Message</th>
					      <th scope="col">Last Operation</th>
					      <th scope="col">Last Updated</th>
					    </tr>
					  </thead>
					  <tbody>
						    <tr>
						      <td>${account.accountId }				</td>
						      <td>${account.customerId.customer_id }</td>
						      <td>${account.accountType }			</td>
						      <td>${account.status }				</td>
						      <td>${account.message }				</td>
						      <td>${account.last_operation }		</td>
						      <td>${account.last_updated }			</td>
						    </tr>
					  </tbody>
  				</table>
			</div>
			<hr>
			<div class="col-sm-10">
				<a href="/sash/banking/account/deposit/search/id2" class="btn btn-primary" tabindex="-1" role="button" aria-disabled="true">DEPOSIT</a>
				<a href="/sash/banking/account/withdraw/search/id2" class="btn btn-success" tabindex="-1" role="button" aria-disabled="true">WITHDRAW</a>
				<a href="/sash/banking/account/delete" class="btn btn-danger" tabindex="-1" role="button" aria-disabled="true">DELETE</a>
	    	</div>	
			
		</div>
		
		<%@ include file = "footer.jsp" %>
		
	</div>

