<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="row">
	<div class="span12">
		<h1>Pinned applications:</h1>
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
		
		<c:if test="${loop.index % 4 eq 0}">
			<ul class="thumbnails">
		</c:if>	
		
		<li class="span3">
		   	<div class="thumbnail">
		      <img src="/img/${app.name}_Logo.png" alt="${app.name}_Logo">
		      <h3>${app.name}</h3>
		      <p id="homeTile${loop.index}">Loading tile...</p>
		      <div class="btn-centered">
		     	<a href="/apps/${app.URL}" class="btn">View App</a>
		      </div>
		    </div>
		</li>
		
		<c:choose>
			<c:when test="${loop.index % 4 eq 3}">
				</ul>
			</c:when>
			<c:when test="${loop.index + 1 eq fn:length(appManager.appList)}">
				</ul>
			</c:when>
		</c:choose>
	</c:forEach>
</div>
	