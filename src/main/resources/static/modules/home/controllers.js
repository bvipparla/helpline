'use strict';
 
angular.module('Home')
 
.controller('HomeController',
    ['$scope', '$http', '$rootScope', '$location', 'AuthenticationService',
    function FnHomeCtrl($scope, $http, $rootScope, $location, AuthenticationService) {
    	$scope.logout = function() {
			$http.post('logout', {}).finally(function() {
				AuthenticationService.ClearCredentials();
				$location.path("/login");
			});
		}
    }]);