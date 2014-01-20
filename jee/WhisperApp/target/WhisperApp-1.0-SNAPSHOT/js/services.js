'use strict';

// fichier avec les services
// ressources : consume des web services avec rest avec passage d'URL en argument
// ca va rechercher des GET / POST


// déclaration du module et de l'utilisation de la librairie ngResource
var whisperServices = angular.module('myApp.services', ['ngResource']);


whisperServices.factory('UsersFactory', function ($resource) 
{
    return $resource('http://localhost:8080/WhisperApp/webresources/users', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    });
});
  
whisperServices.factory('UserWhispersFactory', function ($resource) 
{
    return $resource('http://localhost:8080/WhisperApp/webresources/whispers/user/:id', {}, {
        show: { method: 'GET', isArray: true}
    });
});  
  
whisperServices.factory('WhispersFactory', function ($resource) 
{
    return $resource('http://localhost:8080/WhisperApp/webresources/whispers', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    });
});

whisperServices.factory('WhisperFactory', function ($resource) 
{
    return $resource('http://localhost:8080/WhisperApp/webresources/whispers/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT'},
        delete: { method: 'DELETE', params: {id: '@id'} }
    });
});