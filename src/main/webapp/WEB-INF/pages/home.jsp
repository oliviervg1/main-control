<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="row">
	<div class="span12">
		<h1 class="lead">Pinned applications:</h1>
	</div>
</div>

<div class="row" id="homeTiles">
	<c:forEach var="app" items="${appManager.appList}" varStatus="loop">
		
		<script type="text/javascript">
		$('#homeTiles').ready(function() {
			$.ajaxSetup({ cache: false }); // This part addresses an IE bug.  without it, IE will only load the first number and will never refresh
			setInterval(function() {
				$.ajax({
			        url: 'apps/${app.URL}/homeTile.html',
			        success: function(data) {
			          $('#homeTile${loop.index}').html(data); //Sort this out
			    	}
				});
			}, 2000); // the "2000" here refers to the time to refresh the div.  it is in milliseconds. 
		});
		</script>	
		
		<c:if test="${loop.index % 3 eq 0}">
			<div class="span12">
			<ul class="thumbnails">
		</c:if>	
		
		<li class="span4">
		   	<a href="/apps/${app.URL}" class="thumbnail app-logo">
		      <img src="/img/${app.name}_Logo.png" alt="${app.name}_Logo">
		      <div class="app-text">
		      	<h3>${app.name}</h3>
		      	<p id="homeTile${loop.index}">Loading tile...</p>
		      </div>
		    </a>
		</li>
		
		<c:choose>
			<c:when test="${loop.index % 3 eq 2}">
				</ul>
				</div>
			</c:when>
			<c:when test="${loop.index + 1 eq fn:length(appManager.appList)}">
				</ul>
				</div>
			</c:when>
		</c:choose>
	</c:forEach>
	</div>
</div>
	