'use strict';

var angular           = require('angular');
var bulk              = require('bulk-require');

var homeModule = [
  'testeMercado.Home.controllers'
];

module.exports = angular.module('testeMercado.Home', homeModule);

bulk(__dirname, ['./**/!(*_index|*.spec).js']);
