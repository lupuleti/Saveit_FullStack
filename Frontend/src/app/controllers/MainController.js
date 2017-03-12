(function(){

  angular
       .module('app')
       .controller('MainController', [
          'navService', '$mdSidenav', '$mdBottomSheet', '$log', '$q', '$state', '$mdToast',
          MainController
       ]).config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);

  function MainController(navService, $mdSidenav, $mdBottomSheet, $log, $q, $state, $mdToast) {
    var vm = this;

    vm.menuItems = [ ];
    vm.selectItem = selectItem;
    vm.toggleItemsList = toggleItemsList;
    vm.showPrices = showPrices;
    vm.showTrend = showTrend;
    vm.title = $state.current.data.title;
    vm.showSimpleToast = showSimpleToast;
    vm.toggleRightSidebar = toggleRightSidebar;

    navService
      .loadAllItems()
      .then(function(menuItems) {
        vm.menuItems = [].concat(menuItems);
      });

    function toggleRightSidebar() {
        $mdSidenav('right').toggle();
    }

    function toggleItemsList() {
      var pending = $mdBottomSheet.hide() || $q.when(true);

      pending.then(function(){
        $mdSidenav('left').toggle();
      });
    }

    function selectItem (item) {
      vm.title = item.name;
      vm.toggleItemsList();
      vm.showSimpleToast(vm.title);
    }

    function showPrices($event) {
        $mdBottomSheet.show({
          parent: angular.element(document.getElementById('content')),
          templateUrl: 'app/views/partials/showPrices.html',
          controller: [ '$mdBottomSheet', ShowPricesController],
          controllerAs: "vm",
          bindToController : true,
          targetEvent: $event
        }).then(function(clickedItem) {
          console.log("opened extra prices modal");
        });

        function ShowPricesController( $mdBottomSheet ) {
          var vm = this;

          console.log("controller loaded");

          vm.close = function(action) {
            $mdBottomSheet.hide(action);
          };
        }
    }

    function showSimpleToast(title) {
      $mdToast.show(
        $mdToast.simple()
          .content(title)
          .hideDelay(2000)
          .position('bottom right')
      );
    }

    function showTrend($event) {
      $mdBottomSheet.show({
        parent: angular.element(document.getElementById('content')),
        templateUrl: 'app/views/partials/showTrend.html',
        controller: [ '$mdBottomSheet', ShowTrendController],
        controllerAs: "vm",
        bindToController : true,
        targetEvent: $event
      }).then(function(clickedItem) {
        console.log("opened trend modal");
      });

      function ShowTrendController( $mdBottomSheet ) {
        var vm = this;

        vm.title = "Current trend on this product";

        vm.dataSource = {
          chart: {
            caption: "Harry's SuperMart",
            subCaption: "Top 5 stores in last month by revenue",
            numberPrefix: "$",
            theme: "ocean"
          },
          data:[{
            label: "Bakersfield Central",
            value: "880000"
          },
            {
              label: "Garden Groove harbour",
              value: "730000"
            },
            {
              label: "Los Angeles Topanga",
              value: "590000"
            },
            {
              label: "Compton-Rancho Dom",
              value: "520000"
            },
            {
              label: "Daly City Serramonte",
              value: "330000"
            }]
        };
        /*vm.performAction = function(action) {
         $mdBottomSheet.hide(action);
         };*/
      }
    }
  }

})();
