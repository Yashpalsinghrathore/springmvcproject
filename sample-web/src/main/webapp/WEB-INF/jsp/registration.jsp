<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<html>
<head>

<style>  
.error{color:red}  
</style>

</head>
<body>
	<form:form method="POST" modelAttribute="UserDto"  action="registration.do" >
		<table width="100%" border="0">
			
			
			<tr>
				<td>
					firstName <form:input path="firstName"/>
					<form:errors path="firstName" cssClass="error"  ></form:errors>
				</td>
				
			</tr>
			
				
			<tr>
				<td>
					lastName <form:input path="lastName"/>
					<form:errors path="lastName" cssClass="error"  ></form:errors>
				</td>
				
			</tr>
			
			
			
			
			<tr>
				<td>
					email <form:input path="email"/>
					<form:errors path="email" cssClass="error" ></form:errors>
				</td>
				
			</tr>

			
			<tr>
				<td>
						password <form:password path="password"/>
						<form:errors path="password" cssClass="error"  ></form:errors>
				</td>
				
			</tr>
			
			
				
			<tr>
				<td>
					mobile <form:input path="mobile"/>
					<form:errors path="mobile" cssClass="error"  ></form:errors>
				</td>
				
			</tr>
			
			
			
			
			
			<tr>
				
				
				<td>
				<input type="submit" value="submit">
				</td>

			</tr>


		</table>


	</form:form>


</body>
</html>