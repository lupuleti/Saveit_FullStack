/**
 * Created by lupuletic on 12/03/2017.
 */
(function () {

    angular
        .module('app')
        .controller('LastWeekController', [
            '$http',
            LastWeekController
        ]);

    function LastWeekController($http) {
        var vm = this;
        $http.get("http://localhost:8090/api/last-week-savings")
            .then(function (data) {
                data = data.data;
                console.log(data.paid_price_per_day);
                 console.log(data.minimum_price_per_day);
                 var data_paid_price_per_day = [];
                 var minimum_price_per_day = [];

                 for (var index = 0; index < 6; index++) {
                 console.log(data.paid_price_per_day[index]);
                 var aux = {
                 "value": data.paid_price_per_day[index]
                 };
                 data_paid_price_per_day.push(aux);
                 aux.value = data.minimum_price_per_day[index];
                 minimum_price_per_day.push(aux);
                 }

                vm.dataSource = {
                    "chart": {
                        "caption": "Harry's SuperMart - Comparison of yearly sales ",
                        "subcaption": "2015 v 2014",
                        "numberprefix": "£",
                        "plotgradientcolor": "",
                        "divlinecolor": "CCCCCC",
                        "showvalues": "0",
                        "captionpadding": "30",
                        "palettecolors": "#f8bd19,#008ee4",
                        "plottooltext": "$seriesname Month : $label Sales : $$value",
                        "theme": "zune"
                    },
                    "categories": [
                        {
                            "category": [
                                {
                                    "label": "Jan"
                                },
                                {
                                    "label": "Feb"
                                },
                                {
                                    "label": "Mar"
                                },
                                {
                                    "label": "Apr"
                                },
                                {
                                    "label": "May"
                                },
                                {
                                    "label": "Jun"
                                }
                            ]
                        }
                    ],
                    "dataset": [
                        {
                            "seriesname": "2015",
                            "data": data_paid_price_per_day
                        },
                        {
                            "seriesname": "2014",
                            "data": minimum_price_per_day
                        }
                    ]
                }
            });
        vm.dataSource = {
            "chart": {
                "caption": "Harry's SuperMart - Comparison of yearly sales ",
                "subcaption": "2015 v 2014",
                "numberprefix": "$",
                "plotgradientcolor": "",
                "divlinecolor": "CCCCCC",
                "showvalues": "0",
                "captionpadding": "30",
                "palettecolors": "#f8bd19,#008ee4",
                "plottooltext": "$seriesname Month : $label Sales : $$value",
                "theme": "zune"
            },
            "categories": [
                {
                    "category": [
                        {
                            "label": "Jan"
                        },
                        {
                            "label": "Feb"
                        },
                        {
                            "label": "Mar"
                        },
                        {
                            "label": "Apr"
                        },
                        {
                            "label": "May"
                        },
                        {
                            "label": "Jun"
                        },
                        {
                            "label": "Jul"
                        },
                        {
                            "label": "Aug"
                        },
                        {
                            "label": "Sep"
                        },
                        {
                            "label": "Oct"
                        },
                        {
                            "label": "Nov"
                        },
                        {
                            "label": "Dec"
                        }
                    ]
                }
            ],
            "dataset": [
                {
                    "seriesname": "2015",
                    "data": [
                        {
                            "value": "22400"
                        },
                        {
                            "value": "24800"
                        },
                        {
                            "value": "21800"
                        },
                        {
                            "value": "21800"
                        },
                        {
                            "value": "24600"
                        },
                        {
                            "value": "27600"
                        },
                        {
                            "value": "26800"
                        },
                        {
                            "value": "27700"
                        },
                        {
                            "value": "23700"
                        },
                        {
                            "value": "25900"
                        },
                        {
                            "value": "26800"
                        },
                        {
                            "value": "24800"
                        }
                    ]
                },
                {
                    "seriesname": "2014",
                    "data": [
                        {
                            "value": "10000"
                        },
                        {
                            "value": "11500"
                        },
                        {
                            "value": "12500"
                        },
                        {
                            "value": "15000"
                        },
                        {
                            "value": "16000"
                        },
                        {
                            "value": "17600"
                        },
                        {
                            "value": "18800"
                        },
                        {
                            "value": "19700"
                        },
                        {
                            "value": "21700"
                        },
                        {
                            "value": "21900"
                        },
                        {
                            "value": "22900"
                        },
                        {
                            "value": "20800"
                        }
                    ]
                }
            ]
        }
    }
})();
