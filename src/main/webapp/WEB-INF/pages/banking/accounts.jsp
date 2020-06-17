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

    <title>SASH - Account Service</title>
  </head>
<body>

	<div class="container-fluid">

		<%@ include file = "header.jsp" %>
		
		<div class="row">
			<div class="col">
				<div class="jumbotron alert alert-primary">
					<center><strong><h2>ALL ACCOUNTS DETAILS</h2></strong></center>
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
		</div>
		
		<%@ include file = "footer.jsp" %>

	</div>

</body>
</html>