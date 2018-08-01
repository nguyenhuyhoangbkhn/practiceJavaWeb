<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit Staff</h1>
<form:form method="post" action="updateCustomer"
	modelAttribute="customer">
	<table>
		<tr>
			<td>ID :</td>
			<td><form:input path="custId" /></td>
		</tr>
		<tr>
			<td>Name :</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>age :</td>
			<td><form:input path="age" /></td>
		</tr>
		<tr>
			<td>position :</td>
			<td><form:select path="position">
					<form:option value="develop" label="develop" />
					<form:option value="tester" label="tester" />
					<form:option value="leader" label="leader" />
				</form:select></td>
		</tr>
		<tr>
			<td>telephone :</td>
			<td><form:input path="telphone" /></td>
		</tr>
		<tr>
			<td>company :</td>
			<td><form:select path="company">
					<form:option value="Rikkei" label="Rikkei" />
					<form:option value="FPT" label="FPT" />
					<form:option value="Viettel" label="Viettel" />
				</form:select></td>
		</tr>
		<tr>
			<td>salary :</td>
			<td><form:input path="salary" /></td>
		</tr>

		<tr>
			<td></td>
			<td><input type="submit" value="Update" /></td>
		</tr>
	</table>
</form:form>
