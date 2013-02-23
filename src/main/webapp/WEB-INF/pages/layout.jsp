<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="Home Automation" ignore="true" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Le styles -->
    <link href="/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 20px;
        padding-bottom: 40px;
      }

      /* Custom container */
      .container-narrow {
        margin: 0 auto;
        max-width: 800px;
      }
      .container-narrow > hr {
        margin: 30px 0;
      }

      /* Main marketing message and sign up button */
      .jumbotron {
	  position: relative;
	  padding: 40px 0;
	  color: #fff;
	  text-align: center;
	  text-shadow: 0 1px 3px rgba(0,0,0,.4), 0 0 30px rgba(0,0,0,.075);
	  background: #020031; /* Old browsers */
	  background: -moz-linear-gradient(45deg,  #020031 0%, #6d3353 100%); /* FF3.6+ */
	  background: -webkit-gradient(linear, left bottom, right top, color-stop(0%,#020031), color-stop(100%,#6d3353)); /* Chrome,Safari4+ */
	  background: -webkit-linear-gradient(45deg,  #020031 0%,#6d3353 100%); /* Chrome10+,Safari5.1+ */
	  background: -o-linear-gradient(45deg,  #020031 0%,#6d3353 100%); /* Opera 11.10+ */
	  background: -ms-linear-gradient(45deg,  #020031 0%,#6d3353 100%); /* IE10+ */
	  background: linear-gradient(45deg,  #020031 0%,#6d3353 100%); /* W3C */
	  filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#020031', endColorstr='#6d3353',GradientType=1 ); /* IE6-9 fallback on horizontal gradient */
	  -webkit-box-shadow: inset 0 3px 7px rgba(0,0,0,.2), inset 0 -3px 7px rgba(0,0,0,.2);
	     -moz-box-shadow: inset 0 3px 7px rgba(0,0,0,.2), inset 0 -3px 7px rgba(0,0,0,.2);
	          box-shadow: inset 0 3px 7px rgba(0,0,0,.2), inset 0 -3px 7px rgba(0,0,0,.2);
	  }
	
	  .jumbotron h1 {
	    font-size: 80px;
	    font-weight: bold;
	    letter-spacing: -1px;
	    line-height: 1;
	  }
	
	  .jumbotron p {
	    font-size: 24px;
	    font-weight: 300;
	    line-height: 1.25;
	    margin-bottom: 30px;
	  }

      /* Supporting marketing content */
      .marketing {
        margin: 30px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
      }
      
      /* Centered buttons */
      .btn-centered {
  	  	margin: 30px 0;
  	  	text-align: center;
  	  }
  	  
  	  /* Button style */
  	  .no-underline :hover {
  	  	text-decoration:none;
  	  }
      
    </style>
    <link href="/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

</head>
<body>

<tiles:insertAttribute name="header" />

<div class="container-narrow">
	<hr>
	<div class="row-fluid marketing">
		<tiles:insertAttribute name="body" />
	</div>
	<tiles:insertAttribute name="footer" />
</div>

<!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/js/jquery.js"></script>
    <script src="/js/bootstrap-dropdown.js"></script>

</body>
</html>