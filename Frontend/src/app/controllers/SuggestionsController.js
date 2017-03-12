/**
 * Created by lupuletic on 12/03/2017.
 */
(function () {

    angular
        .module('app')
        .controller('SuggestionsController', [
            '$http',
            '$stateParams',
            SuggestionsController
        ]);

    function SuggestionsController($http, $stateParams) {
        var vm = this;
        vm.offers = [];
        $http.get("http://localhost:8090/api/offers/product-title/" + $stateParams.title)
            .then(function (data) {
                data.data.forEach(function(offer){
                    console.log($stateParams);
                    offer.myDataSource = {
                        chart: {
                            caption: "Money Breakdown",
                            subcaption: "Last Year",
                            startingangle: "120",
                            showlabels: "0",
                            showlegend: "1",
                            enablemultislicing: "0",
                            slicingdistance: "15",
                            showpercentvalues: "1",
                            showpercentintooltip: "0",
                            plottooltext: "$label : £ $datavalue ",
                            theme: "fint"
                        },
                        data: [
                            {
                                label: "Lost money",
                                value: $stateParams.price - offer.price
                            },
                            {
                                label: "Actual Price",
                                value: offer.price
                            }
                        ]
                    }
                });
                vm.offers = data.data;
            });
    }

})();