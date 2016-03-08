'use strict';

var factoriesModule = require('./_index');

/**
 * @ngInject
 */
function messageDialog() {
  var _build = function (scope, titulo, mensagem) {
    scope.tituloDialog = titulo;
    scope.mensagemDialog = mensagem;
    scope.showDialog = true;
  };
  return {
    info: function (scope, titulo, mensagem) {
      _build(scope, titulo, mensagem);
      scope.levelDialog = 'info';
    },
    alert: function (scope, titulo, mensagem) {
      _build(scope, titulo, mensagem);
      scope.levelDialog = 'alert';
    },
    error: function (scope, titulo, mensagem) {
      console.log(titulo);
      console.log(mensagem);
      _build(scope, titulo, mensagem);
      scope.levelDialog = 'error';
    }
  };
}

factoriesModule.factory('messageDialog', messageDialog);