<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

	<h1>Hello! ${message}</h1>
	
	<form:form method="POST" modelAttribute="deviceList">
		<table>
	 		<tr>
				<td>Devices Available:</td>
				<td>
				    <form:select path="deviceList" multiple="false">
				    	<option value="NONE"> --- Select --- </option>
	  					<c:forEach var="device" items="${deviceList.deviceList}">
	    					<option value="${device.URL}"> ${device.name} </option>
	  					</c:forEach>
					</form:select>
	        	</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="View device"></td>
			</tr>
		</table>
 	</form:form>
 
</body>
</html>