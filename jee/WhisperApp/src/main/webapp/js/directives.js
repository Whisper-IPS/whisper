'use strict';


// fichier contenant les directives

angular.module('myApp.directives', []).directive('appVersion', ['version', function(version) 
{
    return function(elm)
    {
      elm.text(version);
    };
    
}]);


// directive pour bloquer la longueur des textarea en écriture à la 
// taille définie dans l'attribut my-maxlenght de la balise textaera
angular.module('myApp.directives', []).directive('myMaxlength', function() 
{
  return {
    require: 'ngModel',
    link: function (scope, element, attrs, ngModelCtrl) {
      var maxlength = Number(attrs.myMaxlength);
      function fromUser(text) {
          if (text.length > maxlength) {
            var transformedInput = text.substring(0, maxlength);
            ngModelCtrl.$setViewValue(transformedInput);
            ngModelCtrl.$render();
            return transformedInput;
          } 
          return text;
      }
      ngModelCtrl.$parsers.push(fromUser);
    }
  }; 
});