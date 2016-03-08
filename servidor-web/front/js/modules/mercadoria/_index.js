'use strict';

var angular           = require('angular');
var bulk              = require('bulk-require');

var mercadoriaModule = [
  'testeMercado.Mercadoria.controllers',
  'testeMercado.Mercadoria.services',
  'testeMercado.Mercadoria.factories'
];

module.exports = angular.module('testeMercado.Mercadoria', mercadoriaModule);

bulk(__dirname, ['./**/!(*_index|*.spec).js']);
