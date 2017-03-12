(function () {
    angular
        .module('app')
        .controller('LatestPurchasesController', [
            "$http",
            LatestPurchasesController
        ]);

    function LatestPurchasesController($http) {
        var vm = this;

        $http.get("http://localhost:8090/purchase/emailAddress/test@test")
            .then(function (data) {
            console.log(data.data);
            vm.purchases = data.data;
        })

    }
})();
