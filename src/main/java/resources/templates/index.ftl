<!DOCTYPE HTML>

<html xmlns="http://www.w3.org/1999/xhtml" ng-app="mainApp">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title ng-bind="title + ' | Cushing Software'">Cushing Software</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" type="text/css" href="/webjars/font-awesome/4.6.3/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.3.7/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/webjars/angular-loading-bar/0.9.0/build/loading-bar.min.css"/>

    <!-- xeditable -->
    <link rel="stylesheet" type="text/css" href="/webjars/angular-xeditable/0.1.11/dist/css/xeditable.css">

    <link rel="stylesheet" type="text/css" href="/webjars/spectrum/1.7.0/spectrum.css">

    <!-- notifications - all types -->
    <link rel="stylesheet" type="text/css" href="/resources/notifications/css/ns-default.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/notifications/css/ns-style-growl.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/notifications/css/ns-style-bar.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/notifications/css/ns-style-attached.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/notifications/css/ns-style-other.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/notifications/css/ns-style-theme.css"/>
    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="/css/main.css">

</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>

            </button>

        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar" bs-navbar>
            <ul class="nav navbar-nav">
                <p>
                    <img src="views/pictures/logo.png " style="margin-top:10px" alt="logo" height="60" width="100">
                </p>


            </ul>
            <ul class="nav navbar-nav navbar-left">
                <li data-match-route="/immediate_tasks"><a href="#/immediate_tasks"><i class="fa fa-users"></i> Cushing Software </a></li>
                <li data-match-route="/dashboard"><a href="#/dashboard"><i class="fa fa-users"></i> Кандидаты</a></li>
                <li data-match-route="/interview"><a href="#/tasks"><i class="fa fa-cogs"></i> Cобытия</a></li>
                <li data-match-route="/service"><a href="#/service"><i class="fa fa-cogs"></i>Служебные</a></li>
                <li data-match-route="/parsing"><a href="#/parsing"><i class="fa fa-cogs"></i>parsing</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <a  class="dropdown-toggle"  data-toggle="dropdown"  role="button" aria-haspopup="true" aria-expanded="false">Welcome ${username}  <span class="caret"  style="margin-top:50px" ></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/logout"  method="post">Logout</a></li>
                </ul>
            </ul>
        </div>
    </div>
</nav>


<div class="container-fluid">

    <div class="row">
        <div class="col-lg-12">
            <div class="slide-main-container">
                <div ng-view autoscroll="true" class="slide-main-animation"></div>
            </div>
        </div>
    </div>

</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/webjars/jquery/3.1.0/dist/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.7/dist/js/bootstrap.min.js"></script>
<script src="js/bootstrap3-typeahead.js"></script>

<script src="/webjars/angularjs/1.5.8/angular.min.js"></script>
<script src="/webjars/angular-sanitize/1.5.8/angular-sanitize.min.js"></script>
<script src="/webjars/angular-route/1.5.8/angular-route.min.js"></script>
<script src="/webjars/angular-animate/1.5.8/angular-animate.min.js"></script>

<script src="/webjars/angular-loading-bar/0.9.0/build/loading-bar.min.js"></script>

<script src="/webjars/lodash/4.13.1/dist/lodash.min.js"></script>

<!-- xeditable -->
<script src="/webjars/angular-xeditable/0.1.11/dist/js/xeditable.min.js"></script>

<script src="/webjars/spectrum/1.7.0/spectrum.js"></script>

<!-- modernirz -->
<script src="/resources/notifications/js/modernizr.js"></script>

<!-- Notifications -->
<script src="/resources/notifications/js/modernizr.custom.js"></script>
<script src="/resources/notifications/js/classie.js"></script>
<script src="/resources/notifications/js/notificationFx.js"></script>

<!-- this page specific scripts -->
<script src="/app/main/app.js"></script>
<script src="/app/services.js"></script>
<script src="/app/main/controllers/dashboard.js"></script>
<script src="/app/main/controllers/applicant.js"></script>
<script src="/app/main/controllers/immediate_tasks.js"></script>
<script src="/app/main/controllers/tasks.js"></script>
<script src="/app/main/controllers/service.js"></script>
<script src="/app/main/controllers/parsing.js"></script>
<script>

</script>
</body>
</html>
