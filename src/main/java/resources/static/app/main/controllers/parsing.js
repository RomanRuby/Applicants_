app.controller('parsingCtrl', function ($scope, ApiService, $timeout, $location) {

    $scope.loading = true;

    $scope.newParsing = {};
    $scope.parsings = {};
    $scope.vacancies = [];
    $scope.resources = [];
    $scope.br = {};


    $scope.addParsing = function () {
        ApiService.postJson('/parsing/applicants', $scope.newParsing, function (data) {
            $scope.parsings.unshift(data.body);
            $scope.br = {};
            $scope.newParsing = {};
            $("#modalAddParsing").modal('hide');
        }, function (br) {
            console.log(br);
            $scope.br = br;

        });
    };
    var getResources = function () {
        ApiService.get('/cushing/applicants/resources', function (data) {
            $scope.resources = data.body;
        });
    }();

    var getVacancies = function () {
        ApiService.get('/cushing/applicants/vacancies', function (data) {
            $scope.vacancies = data.body;
        });
    }();

});
