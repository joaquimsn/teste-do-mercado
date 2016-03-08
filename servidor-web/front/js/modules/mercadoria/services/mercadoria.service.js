'use strict';

var servicesModule = require('./_index');

/**
 * @ngInject
 */
function mercadoriaService(requestService) {
  var URL = '/teste-do-mercado/api/mercadorias';

  this.buscarTodas = function (cb) {
    requestService.execute(cb, URL);
  };

  this.cadastrar = function (cb, data) {
    requestService.post(cb, URL, data);
  };
}

servicesModule.service('mercadoriaService', mercadoriaService);