<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add New Staff</h1>
<form:form method="post" action="addstaff">
	<table>
		<tr>
			<td>ID :</td>
			<td><form:input path="staffid" /></td>
		</tr>
		<tr>
			<td>Name :</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Gender :</td>
			<td><form:select path="gender">
					<form:option value="male" label="male" />
					<form:option value="female" label="female" />
				</form:select></td>
		</tr>
		<tr>
			<td>Age :</td>
			<td><form:input path="age" /></td>
		</tr>
		<tr>
			<td>Company :</td>
			<td><form:select path="company">
					<form:option value="Rikkei" label="Rikkei" />
					<form:option value="FPT" label="FPT" />
					<form:option value="Viettel" label="Viettel" />
				</form:select></td>
		</tr>
		<tr>
			<td>Position :</td>
			<td><form:select path="position">
					<form:option value="develop" label="develop" />
					<form:option value="tester" label="tester" />
					<form:option value="leader" label="leader" />
				</form:select></td>
		</tr>
		<tr>
			<td>Address :</td>
			<td><form:input path="address" /></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Add" /></td>
		</tr>
	</table>
</form:form>
