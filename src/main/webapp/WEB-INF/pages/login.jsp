<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9"><![endif]-->
<!--[if gt IE 8]><!--><html class="no-js"><!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>
        Automat.in - Sign In
    </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <script src="/static/javascript/1.2.2/adminflare-demo-init.min.js" type="text/javascript"></script>

    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        // Include Bootstrap stylesheet
        document.write('<link href="/static/css/' + DEMO_ADMINFLARE_VERSION + '/' + DEMO_CURRENT_THEME + '/bootstrap.min.css" media="all" rel="stylesheet" type="text/css" id="bootstrap-css">');
        // Include AdminFlare stylesheet
        document.write('<link href="/static/css/' + DEMO_ADMINFLARE_VERSION + '/' + DEMO_CURRENT_THEME + '/adminflare.min.css" media="all" rel="stylesheet" type="text/css" id="adminflare-css">');
    </script>

    <script src="/static/javascript/1.2.2/modernizr-jquery.min.js" type="text/javascript"></script>
    <script src="/static/javascript/1.2.2/adminflare-demo.min.js" type="text/javascript"></script>

    <!--[if lte IE 9]>
        <script src="assets/javascript/jquery.placeholder.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('input, textarea').placeholder();
            });
        </script>
    <![endif]-->

    <style type="text/css">
        body {
            padding: 0;
            background: #292929 url("/static/images/left-menu-bg.png");
        }

        a, input, button {
            outline: 0 !important;
        }

        .signin-container {
            margin: 0 auto;
            width: 260px;
        }

        .signin-container form .btn, .signin-container input, .signin-container label, .social p {
            font-size: 14px;
        }

        .signin-container input, .social p, .signin-container form {
            box-sizing:border-box;
            -moz-box-sizing:border-box;
            -webkit-box-sizing:border-box;
        }

        .signin-container .btn {
            border: none;
        }

        a.header, .social p {
            -webkit-text-shadow: rgba(0, 0, 0, 0.8) 0 -1px 0;
            -moz-text-shadow: rgba(0, 0, 0, 0.8) 0 -1px 0;
            -o-text-shadow: rgba(0, 0, 0, 0.8) 0 -1px 0;
            text-shadow: rgba(0, 0, 0, 0.8) 0 -1px 0;
        }

        .signin-container form,
        .signin-container input,
        .signin-container,
        a.header span,
        a.header img,
        .social a {
            -webkit-transition: all 0.2s;
            -moz-transition: all 0.2s;
            -o-transition: all 0.2s;
            transition: all 0.2s;
        }



        /* ======================================================================= */
        /* Logo */

        a.header {
            display: block;
            margin: 0 auto 40px auto;
            font-size: 16px;
            line-height: 22px;
            text-decoration: none;
            width: 195px;
        }

        a.header span, a.header strong {
            margin-left: -1px;
            color: #fff;
        }

        a.header img, a.header span {
            opacity: 0.5;
            filter: ~"alpha(opacity=50)";
        }

        a.header:hover img, a.header:hover span {
            opacity: 0.9;
            filter: ~"alpha(opacity=90)";
        }

        a.header strong {
            font-size: 22px;
        }

        a.header img {
            display: block;
            float: left;
            margin: -6px 10px 0 0;
            position: relative;
        }

        /* ======================================================================= */
        /* Form */

        .signin-container form {
            width: 100%;
            margin: 0;
        }

        .fields {
            -webkit-border-radius: 3px;
            -moz-border-radius: 3px;
            border-radius: 3px;
            border: 1px solid rgba(0, 0, 0, 1);
            -webkit-box-shadow: rgba(255, 255, 255, 0.2) 0 1px 0;
            -moz-box-shadow: rgba(255, 255, 255, 0.2) 0 1px 0;
            box-shadow: rgba(255, 255, 255, 0.2) 0 1px 0;
        }

        .remember-me {
            color: white;
            margin-left: 65px; 
            margin-top: 5px;
        }

        .signin-container form .btn {
            line-height: 26px;
            margin-top: 15px;
        }

        .fields input {
            background: rgba(255, 255, 255, 1);
            border: solid #dedede;
            border-width:  0 0 1px 0;
            -webkit-border-radius: 0;
            -moz-border-radius: 0;
            border-radius: 0;
            -webkit-box-shadow: none;
            -moz-box-shadow: none;
            box-shadow: none;
            height: 40px;
            margin: 0;
            padding: 0 15px;
            width: 100%;
        }

        .fields input[type=password] {
            padding-right: 70px;
        }

        .fields input:nth-child(1) {
            -webkit-border-radius: 3px 3px 0 0;
            -moz-border-radius: 3px 3px 0 0;
            border-radius: 3px 3px 0 0;
        }

        .fields input:nth-child(2) {
            border: none;
            -webkit-border-radius: 0 0 3px 3px;
            -moz-border-radius: 0 0 3px 3px;
            border-radius: 0 0 3px 3px;
        }

        .fields input:focus {
            border-color: #dedede;
            -webkit-box-shadow: none;
            -moz-box-shadow: none;
            box-shadow: none;
        }

    </style>

    <script type="text/javascript">
        $(document).ready(function() {
            var updateBoxPosition = function() {
                $('.signin-container').css({
                    'margin-top': ($(window).height() - $('.signin-container').height()) / 2
                });
            };
            $(window).resize(updateBoxPosition);
            setTimeout(updateBoxPosition, 50);
        });
    </script>
</head>

<body onload='document.f.j_username.focus();'>

    <!-- Page content
        ================================================== -->
    <section class="signin-container">
        <a href="dashboard.html" title="AdminFlare" class="header">
            <img src="/static/images/af-logo-signin.png" alt="Sign in to Automat.in">
            <span>
                Sign in to<br>
                <strong>Automat.in</strong>
            </span>
        </a>

        <c:if test="${not empty error}">
            <div>
                Your login attempt was not successful, try again. Caused :
                ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>

        <form name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
            <fieldset>
                <div class="fields">
                    <input type="text" name="j_username" placeholder="Username" id="id_username" tabindex="1">

                    <input type="password" name="j_password" placeholder="Password" id="id_password" tabindex="2">
                </div>

                <label class="checkbox remember-me"><input type="checkbox" name="_spring_security_remember_me" id="j_remember" tabindex="3"/>Remember Me?</label>

                <button type="submit" value="submit" class="btn btn-primary btn-block" tabindex="4">Sign In</button>
            </fieldset>
        </form>
    </section>

</body>
</html>