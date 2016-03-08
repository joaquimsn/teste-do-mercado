'use strict';

var factoriesModule = require('./_index');

function systemUri(SystemUriConfig) {
  return {
    home: function () {
      return SystemUriConfig.home;
    },
    mercadorias: function () {
      return SystemUriConfig.mercadorias;
    },
    mercadoriasCreate: function () {
      return SystemUriConfig.mercadoriasCreate;
    },
    mercadoriasUpdate: function (id) {
      return SystemUriConfig.mercadoriasUpdate(':id', id);
    },
    notFound: function () {
      return SystemUriConfig.notFound;
    }
  };
}

factoriesModule.factory('systemUri', systemUri);