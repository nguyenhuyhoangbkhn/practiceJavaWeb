<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Applicant</title>

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



<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/validate.js"></script>
<style>

</style>
</head>
<body>
	<form:form action="addstaff" method="POST" id="staffForm">
		<table>
			<tr>
				<td>ID :</td>
				<td><form:input path="id" id="idStaff"/></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name" id = "nameStaff"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" id='email' /></td>
			</tr>
			<tr>
				<td>Position</td>
				<td><form:select path="position">
						<form:option value="developer" label="developer" />
						<form:option value="tester" label="tester" />
						<form:option value="leader" label="leader" />
					</form:select></td>

			</tr>
			<tr>
				<td>Gender</td>
				<td><form:select path="gender">
						<form:option value="male" label="male" />
						<form:option value="female" label="female" />
					</form:select></td>
			</tr>
			<tr>
				<td>Company</td>
				<td><form:select path="company">
						<form:option value="Rikkei" label="Rikkei" />
						<form:option value="FPT" label="FPT" />
						<form:option value="Viettel" label="Viettel" />
					</form:select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add" id="validate" onclick="return validateForm()"/></td>
			</tr>
		</table>
	</form:form>

</body>
</html>