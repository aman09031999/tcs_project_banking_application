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

    <title>SASH - Transaction Service</title>
  </head>
<body>

	<div class="container">
		<div class="jumbotron alert alert-primary">
			<center><strong><h2>ALL TRANSACTIONS</h2></strong></center>
			<hr>
			<div class="table-responsive">
 				<table class="table table-striped table-hover">
 					<thead>
					    <tr>
					      <th scope="col">Transaction ID</th>
					      <th scope="col">Customer ID</th>
					      <th scope="col">Source Account</th>
					      <th scope="col">Destination Account</th>
					      <th scope="col">Date of Transaction</th>
					      <th scope="col">Amount</th>
					    </tr>
					  </thead>
					  <tbody>
					    <c:forEach items="${transaction}" var="obj">
						    <tr>
						      <td>${obj.tx_id }</td>
						      <td>${obj.customer_id.customer_id }</td>
						      <td>${obj.source }</td>
						      <td>${obj.destination }</td>
						      <td>${obj.dot }</td>
						      <td>${obj.amount }</td>
						    </tr>
					    </c:forEach>
					  </tbody>
  				</table>
			</div>		
		</div>
	</div>

</body>
</html>