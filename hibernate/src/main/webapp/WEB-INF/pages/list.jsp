<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Applicant List</title>


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">

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
	src="${pageContext.request.contextPath}/js/javascript.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/validate.js"></script>

</head>
<body>



	<a href="${pageContext.request.contextPath}/form">Create Staff</a>

	<br />


	<table border="1" id="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Position</th>
				<th>Gender</th>
				<th>Email</th>
				<th>Skills</th>
				<th>Delete</th>
				<th>Edit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${applicantInfos}" var="info">

				<tr>
					<td>${info.name}</td>
					<td>${info.position}</td>
					<td>${info.gender}</td>
					<td>${info.email}</td>
					<td>${info.company}</td>
					<td><a href="edit?id=${info.id}">Edit</a></td>
					<td><a href="deleteApplicant?id=${info.id}">Delete</a></td>

				</tr>

			</c:forEach>
		</tbody>
	</table>
	<c:if test="${not empty message}">

		<div class="message">${message}</div>
	</c:if>



</body>
</html>