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

  function postDev (cb, path, data) {
    console.log(data);
    var promisse = $http.get('/api/system/uri');
    promisse.success(function (uri) {
      console.log(data);
      cb($http.post(uri + path, data, [{'Content-Type': 'application/json'}]));
    });
    promisse.error(function (err) {
      console.log('Erro ao cadastrar de: ' + route);
      console.log(err);
    });
  }

  function postProd (cb, path, data) {
    var uri = 'http://rest.joaquimsn.com:4000';
    cb($http.post(uri + path, data, [{'Content-Type': 'application/json'}]));
  }


  return {
    execute: ($location.$$port === 80) ? requestProd : requestDev,
    post: ($location.$$port === 80) ? postProd : postDev
  };
}

factoriesModule.factory('requestService', requestService);
