<!DOCTYPE html>
<html lang="en" ng-app="noah.qa">
	<head>
		<meta charset="utf-8">
		<title>The Noah Project</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="Tanawat Tassana">
		<link href="resources/twitter-bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="resources/fontawesome/css/font-awesome.css" rel="stylesheet">
		<link href="resources/styles/main.css" rel="stylesheet">
		<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link rel="shortcut icon" href="resources/images/ship.ico">
	</head>
	<body>
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container">
					<a class="brand" href="#/dashboard">&bull;&bull;&nbsp;the Noah Project&nbsp;&bull;&bull;</a>
					<ul class="nav">
						<li ng-show="hasLocalUser"><a href="#/dashboard">Dashboard</a></li>
						<li ng-show="hasLocalUser"><a href="#/suit">Test Suit</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container">
			<div ng-view></div>
		</div>
		<script src="resources/angularjs/lib/jquery-1.8.1.min.js"></script>
		<script src="resources/twitter-bootstrap/js/bootstrap.min.js"></script>
		<script src="resources/angularjs/lib/angular/angular.min.js"></script>
		<script src="resources/angularjs/lib/angular/angular-resource.min.js"></script>
		<script src="resources/angularjs/js/app.js"></script>
		<script src="resources/angularjs/js/services.js"></script>
		<script src="resources/angularjs/js/controllers.js"></script>
		<script src="resources/angularjs/js/testsuite/testsuite.js"></script>
	</body>
</html>