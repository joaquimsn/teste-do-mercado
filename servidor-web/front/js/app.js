'use strict';

var angular = require('angular');

// Modules
require('./modules/main/_index');
require('./modules/home/_index');
require('./modules/mercadoria/_index');
require('angular-route');
require('angular-animate');

var requires = [
  'testeMercado.Main',
  'testeMercado.Home',
  'testeMercado.Mercadoria',
  'ngRoute',
  'ngAnimate'
];

angular.module('testeMercado', requires);
angular.module('testeMercado').config(require('./system.config'));
angular.module('testeMercado').run(require('./system.run'));
angular.module('testeMercado').constant('SystemUriConfig', require('./system.constants'));