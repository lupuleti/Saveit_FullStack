/**
 * Created by idriosiris on 12/03/2017.
 */
(function () {
    angular
        .module('app')
        .controller('PurchaseController', [
            "$http",
            "$stateParams",
            "$state",
            "$mdBottomSheet",
            PurchaseController
        ]);

    function PurchaseController($http, $stateParams, $state, $mdBottomSheet) {
        var vm = this;
        var http = $http;
        vm.showPrices = showPrices;
        vm.showTrend = showTrend;
        console.log($stateParams);
        http.get("http://localhost:8090/product/purchase-id/" + $stateParams.id)
            .then(function (data) {
                console.log(data.data);
                vm.products = data.data;
            });

        function showPrices($event, productTitle) {
            $mdBottomSheet.show({
                                    parent: angular.element(document.getElementById('content')),
                                    templateUrl: 'app/views/partials/showPrices.html',
                                    controller: ['$mdBottomSheet', ShowPricesController],
                                    controllerAs: "vm",
                                    bindToController: true,
                                    targetEvent: $event
                                }).then(function (clickedItem) {
                console.log("opened extra prices modal");
            });

            function ShowPricesController($mdBottomSheet) {
                var vm = this;
                vm.offers = [];
                http.get("http://localhost:8090/api/offers/product-title/" + productTitle)
                    .then(function (data) {
                        console.log(data.data);
                        vm.offers = data.data;
                    });

                vm.close = function (action) {
                    $mdBottomSheet.hide(action);
                };
            }
        }

        function showTrend($event) {
            $mdBottomSheet.show({
                                    parent: angular.element(document.getElementById('content')),
                                    templateUrl: 'app/views/partials/showTrend.html',
                                    controller: ['$mdBottomSheet', ShowTrendController],
                                    controllerAs: "vm",
                                    bindToController: true,
                                    targetEvent: $event
                                }).then(function (clickedItem) {
                console.log("opened trend modal");
            });

            function ShowTrendController($mdBottomSheet) {
                var vm = this;

                vm.title = "Current trend on this product";

                vm.dataSource = {
                    chart: {
                        caption: "Harry's SuperMart",
                        subCaption: "Top 5 stores in last month by revenue",
                        numberPrefix: "$",
                        theme: "ocean"
                    },
                    data: [{
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