'use strict';

var controllersModule = require('./_index');

/**
 * @ngInject
 */
function HomeController($scope) {
  $scope.message = "Olá, para registrar uma mercadoria clique no menu ao lado, na opção cadastro";
}

controllersModule.controller('HomeController', HomeController);