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

    <title>SASH - Customer Service</title>
  </head>
<body>

	<div class="container-fluid">
		
		<%@ include file = "header.jsp" %>
		<br>
		<div class="jumbotron alert alert-primary">
			<center><strong><h2>ALL CUSTOMER DETAILS</h2></strong></center>
			<hr>
			<div class="table-responsive">
 				<table class="table table-striped table-hover">
 					<thead>
					    <tr>
					      <th scope="col">Customer ID</th>
					      <th scope="col">Customer Name</th>
					      <th scope="col">Age</th>
					      <th scope="col">Date of Birth</th>
					      <th scope="col">Address</th>
					      <th scope="col">Email</th>
					      <th scope="col">Contact 1</th>
					      <th scope="col">Contact 2</th>
					      <th scope="col">Created On</th>
					      <th scope="col">Last Operation</th>
					      <th scope="col">Last Updated On</th>
					      <th scope="col">Message</th>
					    </tr>
					  </thead>
					  <tbody>
					    <c:forEach items="${customer}" var="obj">
						    <tr>
						      <td>${obj.customer_id }</td>
						      <td>${obj.customer_name }</td>
						      <td>${obj.age }</td>
						      <td>${obj.dob }</td>
						      <td>${obj.address }</td>
						      <td>${obj.customer_email }</td>
						      <td>${obj.customer_contact1 }</td>
						      <td>${obj.customer_contact2 }</td>
						      <td>${obj.doc }</td>
						      <td>${obj.last_operation }</td>
						      <td>${obj.last_updated }</td>
						      <td>${obj.message }</td>
						    </tr>
					    </c:forEach>
					  </tbody>
  				</table>
			</div>			
		</div>
		
		<%@ include file = "footer.jsp" %>
		
	</div>

</body>
</html>