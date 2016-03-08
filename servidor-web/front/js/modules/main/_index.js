'use strict';

var angular           = require('angular');
var bulk              = require('bulk-require');

var mainModule = [
  'testeMercado.Main.controllers'
];

module.exports = angular.module('testeMercado.Main', mainModule);

bulk(__dirname, ['./**/!(*_index|*.spec).js']);
