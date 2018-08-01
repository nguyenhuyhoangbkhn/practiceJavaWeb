<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Applicant</title>
<style>
.error-message {
	color: red;
	font-size: 90%;
	font-style: italic;
}
</style>
</head>
<body>
	<form:form action="editStaff" method="POST" modelAttribute="applicantInfo">
		<table>
			<tr>
				<td>id</td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
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
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>