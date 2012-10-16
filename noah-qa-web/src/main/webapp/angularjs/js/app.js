'use strict';

angular.module('noah.qa', []).
  config(['$routeProvider', function($routeProvider) {
	$routeProvider.
		when('/login', {templateUrl: 'resources/angularjs/partials/login.html'}).
		when('/suite/import', {templateUrl: 'resources/angularjs/partials/testsuite/testsuite-import.html'}).
		otherwise({redirectTo: '/login'});
  }]);
