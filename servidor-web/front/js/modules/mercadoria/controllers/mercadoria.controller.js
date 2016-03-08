'use strict';

var controllersModule = require('./_index');

/**
 * @ngInject
 */
function MercadoriaController($scope, mercadoriaService) {
  function buscarTodasCb (promisse) {
    promisse.success(function (mercadorias) {
      $scope.mercadorias = mercadorias;
    });
    promisse.error(function (err) {
      console.log('Erro ao buscar as categorias');
      console.log(err);
    });
  }

  mercadoriaService.buscarTodas(buscarTodasCb);
}

controllersModule.controller('MercadoriaController', MercadoriaController);
