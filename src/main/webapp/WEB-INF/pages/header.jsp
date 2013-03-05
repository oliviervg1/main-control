<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="masthead">
	<div class="container-narrow"> 
		<ul class="nav nav-pills pull-right">
			<li><a href="/home">Home</a></li>
	        <li><a href="#">About</a></li>
	        <li><a href="#">Contact</a></li>
	        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Installed Applications <b class="caret"></b></a>
				<ul class="dropdown-menu">
	                <c:forEach var="app" items="${appManager.appList}">
	    			<li><a href="/apps/${app.URL}">${app.name}</a></li>
	  				</c:forEach>
	            </ul>
			</li>
		</ul>
		
	    <img class="pull-left" src="/img/Logo_Home_Automation.png" alt="Home_Automation_Logo" width="30" height="30">
	    <h1 class=" lead branding">Automat.in - Smart Home</h1>
	    
	    <hr>
	    
	</div>
</div>

<div class="jumbotron">
	<div class="container">
		<h1>${pageName}</h1>
		<p class="lead">${pageDetails}</p>
	</div>
</div>