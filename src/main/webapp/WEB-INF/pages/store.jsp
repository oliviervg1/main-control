<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!--=============================================================-->

<script>
$('#appTabs a').click(function (e) {
  e.preventDefault();
  $(this).tab('show');
});
</script>

<section class="row-fluid">
	
	<ul id="appTabs" class="nav nav-tabs">
		<li class="active"><a href="#add" data-toggle="tab">Add</a></li>
	    <li><a href="#remove" data-toggle="tab">Remove</a></li>
	</ul>
	
	<div id="appTabsContent" class="tab-content">
		<!-- Add Apps -->
		<div class="tab-pane fade active in" id="add">
			<h1 class="lead">Install an app</h1>
				
			<form:form class="form-inline" modelAttribute="uploadItem" action="store/addApp" method="post" enctype="multipart/form-data">
				<fieldset>
					<form:label class="control-label" for="fileData" path="fileData">Application file</form:label>
					<form:input path="fileData" type="file"/>
					<button type="submit" class="btn btn-primary">Add app</button>
				</fieldset>
			</form:form>
		</div>
		
		<!-- Remove Apps -->
		<div class="tab-pane fade" id="remove">
			<h1 class="lead">Select an app to remove</h1>
			
			<table class="table table-hover">
			  <thead>
			    <tr>
			      <th>#</th>
			      <th>Application</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach var="app" items="${appManager.appList}" varStatus="loop">
				<tr>
			    	<td>${loop.index}</td>
					<td><a href="/store/removeApp?p=${app.URL}">${app.name}</a></td>
				</tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
</section>