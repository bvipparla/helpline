'use strict';

// declare modules
angular.module('Authentication', []);
angular.module('Home', []);

angular.module('HelplineApplication', [
    'Authentication',
    'Home',
    'ngRoute',
    'ngCookies'
])
 
.config(['$routeProvider', '$httpProvider', function FnRouteProvider($routeProvider, $httpProvider) {
    $routeProvider
        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'modules/authentication/views/login.html',
            hideMenus: true
        })
        .when('/home', {
            controller: 'HomeController',
            templateUrl: 'modules/home/views/home.html'
        })
        .otherwise({ redirectTo: '/login' });
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
}])
 
.run(['$rootScope', '$location', '$cookieStore', '$http',
    function FnRun($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }
 
        $rootScope.$on('$locationChangeStart', function FnLocationChange(event, next, current) {
            // redirect to login page if not logged in
            if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
                $location.path('/login');
            }
        });
    }]);