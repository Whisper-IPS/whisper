'use strict';

// fichier contenant les controleurs


// nom du module
var app = angular.module('myApp.controllers', []);



// nettoyage du cache de l'explorateur ( en dev)
//app.run(function($rootScope, $templateCache) 
//{
//   $rootScope.$on('$viewContentLoaded', function() 
//   {
//       $templateCache.removeAll();
//   });
//});


// controleur du mur(relatif à la vue whisper-list.html)
app.controller('WhisperListCtrl', ['$scope', 'WhispersFactory', function($scope, WhispersFactory)
    {
        // récupération de tous les messages
        $scope.allwhispers = WhispersFactory.query();



        // selection du message dans le tableau
        $scope.showSelectedElement = function(c)
        {
            $scope.selected = c;
        };


    }]);


// controleur pour la création d'un utilisateur (relatif à la vue user-creation.html)
app.controller('UserCreationCtrl', ['$scope', 'UsersFactory', '$location', function($scope, UsersFactory, $location)
    {
        // récupération des utilisateurs
        $scope.allusers = UsersFactory.query();

        // redirection vers acceuil apres inscription
        $scope.createNewUser = function()
        {
            UsersFactory.create($scope.users);
            $location.path('/whisper-list');
        };
    }]);


// controleur pour le mur perso avec loggin
app.controller('WhisperDetailCtrl', ['$scope', '$routeParams', 'WhisperFactory', '$location', function($scope, $routeParams, WhisperFactory, $location)
    {
        // on récupere l'entity associé au $routeParams.id.
        $scope.whispers = WhisperFactory.show({id: $routeParams.id});

        // on recupere l'id assosicé à la route via $routeParams.id pour le 1° params puis on recupere le 2° params l'objet $scope.whispers.  
        $scope.updateWhisper = function()
        {
            WhisperFactory.update({id: $routeParams.id}, $scope.whispers);
            $location.path('/user-list/' + $scope.whispers.userId.userId);
        };

        // juste une rédirection vers le wall.
        $scope.cancel = function()
        {
            $location.path('/user-list/' + $scope.whispers.userId.userId);
        };
    }]);


// controleur pour la creation d'un message 
app.controller('WhisperCreationCtrl', ['$scope', 'WhispersFactory', '$routeParams', '$location', function($scope, WhispersFactory, $routeParams, $location)
    {
        // récupération de l'id du user
        $scope.userId = $routeParams.id;

        // creation message + redirection sur mur perso 
        $scope.createNewWhisper = function()
        {
            WhispersFactory.create($scope.whispers);
            $location.path('/user-list/' + $routeParams.id);
            window.location = '#/user-list/' + $routeParams.id;
            history.go(0);
        };
    }]);


// controleur pour le login
app.controller('WhisperConnection', function($scope, $http, $location) {
    $scope.sessiondiscard = function() {
        window.sessionStorage.clear();
        window.location = '#/wall';
        history.go(0);


    };

    $scope.getConnection = function() {
        $http.get('http://localhost:8080/WhisperApp/webresources/users/' + $scope.username + '/' + $scope.pwd).success(function(data) {
            $scope.test = data;
            if (data === "0") {
                alert('Identification incorrect ');
            }
            else {

                window.sessionStorage['id'] = $scope.test;
                window.sessionStorage['pseudo'] = $scope.username;
                $location.url('/user-list/' + $scope.test);
                window.location = '/user-list/' + $scope.test;
                history.go(0);

//               
            }

        });
    };

});


// controleur pour le tableau du mur perso apres login
app.controller('UserListCtrl', ['$scope', '$routeParams', 'UserWhispersFactory', 'WhisperFactory', '$location', function($scope, $routeParams, UserWhispersFactory, WhisperFactory, $location)
    {
        if (window.sessionStorage['id'] != $routeParams.id)
        {
            window.location = '#/wall';
            history.go(0);
        }
        ;


        // récupération des messages de l'utilisateur
        $scope.userallwhispers = UserWhispersFactory.show({id: $routeParams.id});

        // suppression du message de l'utilisateur + redirection sur le mur perso
        $scope.deleteWhisper = function(whisperId)
        {
            WhisperFactory.delete({id: whisperId});
            $scope.userallwhispers = UserWhispersFactory.show({id: $routeParams.id});
            $location.path('/user-list/' + $routeParams.id);
        };

        // creation nouveau message à partir de la page perso
        $scope.createNewWhisper = function()
        {
            $location.path('/whisper-creation/' + $routeParams.id);
        };

        // modification du message
        $scope.editWhisper = function(whisperId)
        {
            $location.path('/whisper-detail/' + whisperId);
        };
    }]);