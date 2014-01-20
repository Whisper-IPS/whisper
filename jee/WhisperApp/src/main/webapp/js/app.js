'use strict';


// déclaration des modules de l'application pour les filtres, services, controleurs, directives et routes
angular.module('myApp', [
  'ngRoute',
  'myApp.filters',
  'myApp.services',
  'myApp.directives',
  'myApp.controllers'
]).
config(['$routeProvider', function($routeProvider) {// déclaration des routes
  $routeProvider.when('/wall', {templateUrl: 'partials/whisper-list.html', controller: 'WhisperListCtrl'});
  $routeProvider.when('/whisper-detail/:id', {templateUrl: 'partials/whisper-detail.html', controller: 'WhisperDetailCtrl'});
  $routeProvider.when('/whisper-creation/:id', {templateUrl: 'partials/whisper-creation.html', controller: 'WhisperCreationCtrl'});
  $routeProvider.when('/user-creation', {templateUrl: 'partials/user-creation.html', controller: 'UserCreationCtrl'});
  $routeProvider.when('/user-list/:id', {templateUrl: 'partials/user-list.html', controller: 'UserListCtrl'});
  $routeProvider.otherwise({redirectTo: '/wall'}); // si la route ne se trouve pas dans celles ci dessus, redirection vers acceuil.
}]);


// routes: 
// ex: '/wall', {templateUrl: 'partials/whisper-list.html', controller: 'WhisperListCtrl'}
// '/wall'  : ce que l'on affiche dans d'URL
// templateUrl : quel fichier aller chercher
//  controller : controleur lié à la route
