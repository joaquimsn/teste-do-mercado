'use strict';

/**
 * @ngInject
 */
function routerConfig($routeProvider, $locationProvider, SystemUriConfig) {
  $routeProvider.
    when(SystemUriConfig.home, {
      templateUrl: 'expose/home/home',
      controller: 'HomeController'
    }).
    when(SystemUriConfig.mercadorias, {
      templateUrl: 'expose/mercadorias/mercadorias',
      controller: 'MercadoriaController'
    }).
    when(SystemUriConfig.mercadoriasCreate, {
      templateUrl: 'expose/mercadorias/mercadoria-create',
      controller: 'MercadoriaCreateController'
    }).
    when(SystemUriConfig.mercadoriasUpdate, {
      templateUrl: 'expose/mercadorias/mercadoria-update',
      controller: 'MrcadoriaUpdateController'
    }).
    when(SystemUriConfig.notFound, {
      templateUrl: 'expose/main/404',
      controller: 'NotFoundController'
    }).
    otherwise({
      redirectTo: SystemUriConfig.notFound
    });
  $locationProvider.html5Mode(true);
}

module.exports = routerConfig;