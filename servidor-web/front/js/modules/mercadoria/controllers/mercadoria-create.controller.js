'use strict';

var controllersModule = require('./_index');

/**
 * @ngInject
 */
function MercadoriaCreateController($scope, modelFactory, mercadoriaService, messageDialog) {
  $scope.mercadoria = modelFactory.of();

  function salvarCb (promisse) {
    promisse.success(function () {
      messageDialog.info($scope, 'Cadastro', 'Mercadoria cadastrada com sucesso');
      $scope.mercadoria = modelFactory.of();
    });
    promisse.error(function (err) {
      messageDialog.error($scope, 'Erro', 'Houve um erro ao cadastrar a mercadoria: ' + err);
    });
  }

  $scope.salvar = function (mercadoria) {
    mercadoriaService.cadastrar(salvarCb, mercadoria);
  };

  $scope.opcoesTipoNegocio = [
    {id: "VENDA", value: "Venda"},
    {id: "COMPRA", value: "Compra"},
  ];
}


controllersModule.controller('MercadoriaCreateController', MercadoriaCreateController);
