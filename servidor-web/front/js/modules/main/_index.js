'use strict';

var angular           = require('angular');
var bulk              = require('bulk-require');

var mainModule = [
  'testeMercado.Main.controllers',
  'testeMercado.Main.directives',
  'testeMercado.Main.factories'
];

module.exports = angular.module('testeMercado.Main', mainModule);

bulk(__dirname, ['./**/!(*_index|*.spec).js']);
