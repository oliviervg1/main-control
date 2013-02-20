<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

	<h1>Hello! ${message}</h1>
	
	<form:form modelAttribute="appManager">
		<table>
	 		<tr>
				<td>Devices Available:</td>
				<td>
				    <form:select name="url" path="selectedURL" multiple="false">
				    	<option value="NONE"> --- Select --- </option>
	  					<c:forEach var="app" items="${appManager.appList}">
	    					<option value="${app.URL}"> ${app.name} </option>
	  					</c:forEach>
					</form:select>
	        	</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="View application"></td>
			</tr>
		</table>
 	</form:form>
 
</body>
</html>