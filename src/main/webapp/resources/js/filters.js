'use strict';

/* Filters */

var AppFilters = angular.module('BracketMadness.filters', []);

AppFilters.filter('interpolate', ['version', function (version) {
    return function (text) {
        return String(text).replace(/\%VERSION\%/mg, version);
    }
}]);
