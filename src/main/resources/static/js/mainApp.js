var mainApp = angular.module('mainApp', ['ui.router']);

mainApp.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');

    $stateProvider
        .state('index', {
            url: '/',
            templateUrl: 'index.html',
            controller: 'mainController'
        });
});