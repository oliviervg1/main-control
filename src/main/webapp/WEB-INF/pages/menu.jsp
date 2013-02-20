<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
	<style>
		.error {
			color: #ff0000;
		}
		 
		.errorblock {
			color: #000;
			background-color: #ffEEEE;
			border: 3px solid #ff0000;
			padding: 8px;
			margin: 16px;
		}
	</style>
</head>
	
<form:form modelAttribute="appManager" action="viewApp">
	<form:errors path="*" cssClass="errorblock" element="div" />
	<table>
 		<tr>
			<td>Apps Available:</td>
			<td>
			    <form:select name="url" path="selectedURL" multiple="false">
			    	<option value=""> --- Select --- </option>
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
 
</html>