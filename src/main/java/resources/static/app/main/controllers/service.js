app.controller('serviceCtrl', function ($scope, ApiService, $filter) {

    $scope.position = '';
    $scope.status = '';
    $scope.newOffice = {};
    $scope.br = {};
    $scope.vacancies = [];

    $scope.newVacancy = {};


    $scope.addVacancy = function () {
        ApiService.postJson('/cushing/applicants/vacancy', $scope.newVacancy, function (data) {
            $scope.vacancies = '';
            $scope.br = {};
            $scope.newVacancy = {};

        }, function (br) {
            $scope.br = br;
        });
    };

    $scope.addOffice = function () {
        ApiService.postJson('/cushing/applicants/office', $scope.newOffice, function (data) {
            notification('success', 'Добавлен новый офис: ' + $scope.office, 5000);
            $scope.office = '';
            $scope.br = {};
            $scope.newOffice = {};
        }, function (br) {
            $scope.br = br;
        });
    };
});
