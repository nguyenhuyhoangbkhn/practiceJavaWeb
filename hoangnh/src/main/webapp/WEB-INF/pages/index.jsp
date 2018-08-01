<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Staff List</title>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js">
<!-- Below is the jQuery file required for using any Jquery component. -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.13/css/dataTables.jqueryui.min.css">
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/js.js"></script>

</head>
<body>
	<div>
		<div class="title">List staff</div>
		<div class="btn-staff">
			<a href="form">add staff</a>
		</div>
		<div>
			<form action="index" id="company">
				<select name="company" form="company">
					<option value="all">All Company</option>
					<option value="FPT">FPT</option>
					<option value="Rikkei">Rikkei</option>
					<option value="Viettel">Viettel</option>
				</select> <input type="submit">
			</form>
		</div>
		<table id="test">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>GENDER</th>
					<th>AGE</th>
					<th>COMPANY</th>
					<th>POSITION</th>
					<th>ADDRESS</th>
					<th>EMAIL</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="staff" items="${list}">
					<tr>
						<td>${staff.staffid}</td>
						<td>${staff.name}</td>
						<td>${staff.gender}</td>
						<td>${staff.age}</td>
						<td>${staff.company}</td>
						<td>${staff.position}</td>
						<td>${staff.address}</td>
						<td>${staff.email}</td>
						<td><a href="edit?custid=${staff.staffid}">Edit</a></td>
						<td><a href="delete?custid=${staff.staffid}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>