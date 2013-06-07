<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9"><![endif]-->
<!--[if gt IE 8]><!--><html class="no-js"><!--<![endif]-->
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>
		Automat.in
	</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width">
		
	<script src="/assets/javascripts/1.2.2/adminflare-demo-init.min.js" type="text/javascript"></script>

	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700" rel="stylesheet" type="text/css">
	<script type="text/javascript">
		// Include Bootstrap stylesheet 
		document.write('<link href="/assets/css/' + DEMO_ADMINFLARE_VERSION + '/' + DEMO_CURRENT_THEME + '/bootstrap.min.css" media="all" rel="stylesheet" type="text/css" id="bootstrap-css">');
		// Include AdminFlare stylesheet 
		document.write('<link href="/assets/css/' + DEMO_ADMINFLARE_VERSION + '/' + DEMO_CURRENT_THEME + '/adminflare.min.css" media="all" rel="stylesheet" type="text/css" id="adminflare-css">');
	</script>
	
	<script src="/assets/javascripts/1.2.2/modernizr-jquery.min.js" type="text/javascript"></script>
	<script src="/assets/javascripts/1.2.2/adminflare-demo.min.js" type="text/javascript"></script>
	<script src="/assets/javascripts/1.2.2/bootstrap.min.js" type="text/javascript"></script>
	<script src="/assets/javascripts/1.2.2/adminflare.min.js" type="text/javascript"></script>
	
	<!-- The stylesheet for the player -->
    <link rel="stylesheet" href="/assets/osmplayer/jquery-ui/dark-hive/jquery-ui-1.8.18.custom.css">
    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
    
    <!-- Script for voice recognition -->
    <script type="text/javascript" src="/assets/javascripts/textarea-helper.js"></script>
    <script type="text/javascript" src="/assets/javascripts/speech-recognizer.js"></script>
    
    <!-- Include osmplayer scripts and templates -->
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.compatibility.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.flags.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.async.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.plugin.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.display.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.image.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.file.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.playLoader.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.players.base.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.players.html5.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.players.flash.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.players.minplayer.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.players.youtube.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.players.vimeo.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.players.limelight.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/minplayer/src/minplayer.controller.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/src/osmplayer.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/src/osmplayer.parser.default.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/src/osmplayer.parser.youtube.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/src/osmplayer.parser.rss.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/src/osmplayer.parser.asx.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/src/osmplayer.parser.xspf.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/src/osmplayer.playlist.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/src/iscroll/src/iscroll.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/src/osmplayer.pager.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/src/osmplayer.teaser.js"></script>
    
	<link rel="stylesheet" href="/assets/osmplayer/templates/default/css/osmplayer_default.css">
	<script type="text/javascript" src="/assets/osmplayer/templates/default/js/osmplayer.default.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/templates/default/js/osmplayer.controller.default.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/templates/default/js/osmplayer.pager.default.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/templates/default/js/osmplayer.playLoader.default.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/templates/default/js/osmplayer.playlist.default.js"></script>
	<script type="text/javascript" src="/assets/osmplayer/templates/default/js/osmplayer.teaser.default.js"></script>

	<!-- Custom styles -->
	<style type="text/css">
    .btn-centered {
  	  	margin-top: 30px;
  	  	text-align: center;
  	}
	
	#homeTiles .span4 {
    	margin-right:-10px;
	}
	
	.app-logo { 
   	  	position: relative; 
  	  	width: 100%; /* for IE 6 */
	}

	.app-text { 
   	  	position: absolute; 
      	top: 105px;
      	left: 15px; 
      	width: 100%;
      	color: #fff;
      	text-decoration:none;
    }
	</style>
</head>

<body>
<script type="text/javascript">demoSetBodyLayout();</script>
<script>
//<![CDATA[
jQuery(function() {
  var found = false;
  jQuery('#main-nav li').each(function() {
	var href = jQuery(this).find('a').attr('href');
	if (href === window.location.pathname) {
	  	jQuery(this).addClass('active');
	  	found = true;
	} 
  });
  
  if (!found) {
	  jQuery('#main-nav li').first().addClass('active');
  }
	
  jQuery('#left-panel-content li').each(function() {
    var href = jQuery(this).find('a').attr('href');
    if(window.location.pathname.indexOf(href) != -1){
    	jQuery(this).addClass('active');
    }
  });
});
//]]>
</script>

	<!-- Main navigation bar
		================================================== -->
	<header class="navbar navbar-fixed-top" id="main-navbar">
		<div class="navbar-inner">
			<div class="container">
				<a class="logo" href="/dashboard"><img alt="automatin_logo" src="/assets/images/af-logo.png"></a>

				<a class="btn nav-button collapsed" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-reorder"></span>
				</a>

				<div class="nav-collapse collapse">
					<ul id="main-nav" class="nav">
						<li><a href="/dashboard">Apps</a></li>
						<li><a href="/store">Store</a></li>
						<li><a href="#">About</a></li>
						<li><a href="#">Contact</a></li>
					</ul>
					<form class="navbar-search pull-left" action="" _lpchecked="1">
						<input type="text" class="search-query" placeholder="Search" style="width: 120px">
					</form>
					<ul class="nav pull-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle usermenu" data-toggle="dropdown">
								<img alt="Avatar" src="/assets/images/avatar.png">
								<span>&nbsp;&nbsp;${loggedUser}</span>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">Profile</a>
								</li>
								<li class="divider"></li>
								<li>
									<a href="<c:url value="/j_spring_security_logout" />" > Sign Out</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</header>
	<!-- / Main navigation bar -->
	
	<!-- Left navigation panel
		================================================== -->
	<nav id="left-panel">
		<div id="left-panel-content">
			<ul>
				<li>
					<a href="/dashboard"><span class="icon-dashboard"></span>Dashboard</a>
				</li>
				<c:forEach var="app" items="${appManager.appList}">
	    		<li>
	    			<a href="/apps/${app.URL}"><span class="${app.icon}"></span>${app.name}</a>
	    		</li>
	  			</c:forEach>
	  			<li>
					<a href="/voice"><span class="icon-bullhorn"></span>Voice</a>
				</li>
	  			<li>
					<a href="/social"><span class="icon-group"></span>Social</a>
				</li>
				<li>
					<a href="#"><span class="icon-wrench"></span>Settings</a>
				</li>
			</ul>
		</div>
		<div class="icon-caret-down"></div>
		<div class="icon-caret-up"></div>
	</nav>
	<!-- / Left navigation panel -->
	
	<!-- Page content
		================================================== -->
	<section class="container">
	
		<h1>${pageName}</h1>
		<p>${pageDetails}</p>
		
		<div class="well">
		<tiles:insertAttribute name="body" />
		</div>
		
		<!-- Page footer
				================================================== -->
		<footer id="main-footer">
			Copyright © 2013 <a href="https://github.com/oliviervg1">Oli FYP</a>, all rights reserved.
			<a href="#" class="pull-right" id="on-top-link">
				On Top&nbsp;<i class=" icon-chevron-up"></i>
			</a>
		</footer>
		<!-- / Page footer -->
	</section>
</body>
</html>