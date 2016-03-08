'use strict';

var factoriesModule = require('./_index');

/**
 * @ngInject
 */
function modelFactory() {
  return {
    of: function () {
      var model = {
        codigo: '',
        nome: '',
        tipo: '',
        tipoNegocio: '',
        preco: '',
        quantidade: ''
      };

      return model;
    }
  };
}

factoriesModule.factory('modelFactory', modelFactory);