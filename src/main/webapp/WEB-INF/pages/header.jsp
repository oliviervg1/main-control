<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="masthead">
	<div class="container-narrow"> 
		<ul class="nav nav-pills pull-right">
			<li><a href="/home">Home</a></li>
	        <li><a href="#">About</a></li>
	        <li><a href="#">Contact</a></li>
	        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Available Applications <b class="caret"></b></a>
				<ul class="dropdown-menu">
	                <c:forEach var="app" items="${appManager.appList}">
	    			<li><a href="/apps/${app.URL}">${app.name}</a></li>
	  				</c:forEach>
	            </ul>
			</li>
		</ul>
	    <h3>Home Automation FYP</h3>
	    
	    <hr>
	    
	</div>
</div>

<div class="jumbotron">
	<div class="container">
		<h1>${pageName}</h1>
		<p class="lead">${pageDetails}</p>
	</div>
</div>