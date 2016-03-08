'use strict';

var directivesModule = require('./_index');

/**
 * @ngInject
 */
function messageDialog($timeout) {
  return {
    replace: true,
    restrict: 'E',
    scope: {
      titulo: "=",
      mensagem: "=",
      show: "="
    },
    templateUrl: 'partials/main/message-dialog',
    link: function (scope, element, attrs) {
      $timeout(function () {
        element.removeAttr('style');
      }, 1000);

      scope.fecharModal = function () {
        scope.show = false;
      };

      scope.$watch('show', function (newValue, oldValue) {
        $timeout(function () {
          if (newValue === true) {
            scope.show = false;
          }
        }, 5000);
      }, true);
    }
  };
}

directivesModule.directive('messageDialog', messageDialog);