'use strict';

/* Services */

var presentServices = angular.module('presentServices', ['ngResource']);

presentServices.factory('Candy', ['$resource', function($resource) {
    return $resource('candies/:candyId', {}, {
      update: {
        method: 'PUT', params: {candyId: '@id'}
      }
    });
}]);

presentServices.factory('Present', ['$resource', function($resource) {
    return $resource('presents/:presentId');
}]);
