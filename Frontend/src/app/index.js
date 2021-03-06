'use strict';

angular.module('angularMaterialAdmin', ['ngAnimate', 'ngCookies',
  'ngSanitize', 'ui.router', 'ngMaterial', 'nvd3', 'app' , 'md.data.table'])

  .config(function ($stateProvider, $urlRouterProvider, $mdThemingProvider,
                    $mdIconProvider) {
    $stateProvider
      .state('home', {
        url: '',
        templateUrl: 'app/views/main.html',
        controller: 'MainController',
        controllerAs: 'vm',
        abstract: true
      })
      .state('home.dashboard', {
        url: '/dashboard',
        templateUrl: 'app/views/dashboard.html',
        data: {
          title: 'Dashboard'
        },
        controller: 'LatestPurchasesController',
        controllerAs: 'vm'
      })
        .state('home.lastweek', {
            url: '/lastweek',
            templateUrl: 'app/views/lastweek.html',
            data: {
                title: 'Last Week'
            },
            controller: 'LastWeekController',
            controllerAs: 'vm'
        })
        .state('home.purchase', {
            url: '/purchase/:id',
            templateUrl: 'app/views/purchase-view.html',
            data: {
                title: 'Purchase Details'
            },
            controller: 'PurchaseController',
            controllerAs: 'vm'
        })
        .state('home.suggestions', {
            url: '/suggestions/:title/:price',
            templateUrl: 'app/views/suggestions.html',
            data: {
                title: 'Suggestions Details'
            },
            controller: 'SuggestionsController',
            controllerAs: 'vm'
        })
        .state('home.overpriced', {
            url: '/overpriced',
            templateUrl: 'app/views/overpriced.html',
            data: {
                title: 'Overpriced'
            }
        })
      /*.state('home.profile', {
        url: '/profile',
        templateUrl: 'app/views/profile.html',
        controller: 'ProfileController',
        controllerAs: 'vm',
        data: {
          title: 'Profile'
        }
      })*/
      /*.state('home.table', {
        url: '/table',
        controller: 'TableController',
        controllerAs: 'vm',
        templateUrl: 'app/views/table.html',
        data: {
          title: 'Table'
        }
      })
      .state('home.data-table', {
        url: '/data-table',
        controller: 'DataTableController',
        controllerAs: 'vm',
        templateUrl: 'app/views/data-table.html',
        data: {
          title: 'Table'
        }
      })*/;

    $urlRouterProvider.otherwise('/dashboard');

    $mdThemingProvider
      .theme('default')
        .primaryPalette('grey', {
          'default': '600'
        })
        .accentPalette('teal', {
          'default': '500'
        })
        .warnPalette('defaultPrimary');

    $mdThemingProvider.theme('dark', 'default')
      .primaryPalette('defaultPrimary')
      .dark();

    $mdThemingProvider.theme('grey', 'default')
      .primaryPalette('grey');

    $mdThemingProvider.theme('custom', 'default')
      .primaryPalette('defaultPrimary', {
        'hue-1': '50'
    });

    $mdThemingProvider.definePalette('defaultPrimary', {
      '50':  '#FFFFFF',
      '100': 'rgb(255, 198, 197)',
      '200': '#E75753',
      '300': '#E75753',
      '400': '#E75753',
      '500': '#E75753',
      '600': '#E75753',
      '700': '#E75753',
      '800': '#E75753',
      '900': '#E75753',
      'A100': '#E75753',
      'A200': '#E75753',
      'A400': '#E75753',
      'A700': '#E75753'
    });

    $mdIconProvider.icon('user', 'assets/images/user.svg', 64);
  });
