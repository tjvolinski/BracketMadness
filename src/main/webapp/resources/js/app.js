'use strict';

var BracketMadness = {};

var App = angular.module('BracketMadness', ['BracketMadness.filters', 'BracketMadness.services', 'BracketMadness.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    
    $routeProvider.when('/bracket', {
        templateUrl: 'bracket/layout',
        controller: BracketController
    });
    
    $routeProvider.when('/calculator', {
        templateUrl: 'calculator/layout',
        controller: BracketController
    });
    
    $routeProvider.when('/results', {
        templateUrl: 'results/layout',
        controller: BracketController
    });
    
    $routeProvider.when('/stats', {
        templateUrl: 'stats/layout',
        controller: BracketController
    });
    
    $routeProvider.otherwise({redirectTo: '/stats'});
}]);
