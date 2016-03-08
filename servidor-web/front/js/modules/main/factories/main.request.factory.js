'use strict';

var factoriesModule = require('./_index');

/**
 * @ngInject
 */
function requestService($http, $location) {
  function requestDev (cb, route) {
    var promisse = $http.get('/api/system/uri');
    promisse.success(function (uri) {
      cb($http.get(uri + route));
    });
    promisse.error(function (err) {
      console.log('Erro ao buscar recursos de: ' + route);
      console.log(err);
    });
    console.log($location);
    console.log($location.$$port);
  }

  function requestProd (cb, route) {
    var uri = 'http://rest.joaquimsn.com:4000';
    cb($http.get(uri + route));
    console.log($location);
    console.log($location.$$port);
  }

  return {
    execute: ($location.$$port === 80) ? requestProd : requestDev
  };
}

factoriesModule.factory('requestService', requestService);
