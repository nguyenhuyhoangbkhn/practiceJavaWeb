<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Spring MVC Resource example</title>


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/css/style.css">

<!-- Below are the Style Sheets required for Data Tables. These can be customized as required -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.13/css/dataTables.jqueryui.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js">
<!-- Below is the jQuery file required for using any Jquery component. -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Below are the jQuery scripts required for Data Tables. -->
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/style/scripts/javaScript.js"></script>

</head>
<body>

	<div>
		<div class="green-text">List staff</div>
		<div class="btn-staff">
			<a href="form">add staff</a>
			<form action="list" id="company">
				<select name="company" form="company">
					<option value="all">All Company</option>
					<option value="FPT">FPT</option>
					<option value="Rikkei">Rikkei</option>
					<option value="Viettel">Viettel</option>
				</select> 
				<input type="submit">
			</form>
		</div>

		<table id="myDatatable">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Company</th>
					<th>Age</th>
					<th>Telephone</th>
					<th>Salary</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="staff" items="${listStaff}">
					<tr>
						<td>${staff.custId}</td>
						<td>${staff.name}</td>
						<td>${staff.company}</td>
						<td>${staff.age}</td>
						<td>${staff.telphone}</td>
						<td>${staff.salary}</td>
						<td><a href="edit?custid=${staff.custId}">Edit</a></td>
						<td><a href="delete?custid=${staff.custId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>