app.controller('dashboardCtrl', function ($scope, ApiService, $timeout, $location) {

    $scope.loading = true;

    $scope.newApplicant = {};
    $scope.applicant = {};
    $scope.applicants = [];
    $scope.offices = [];
    $scope.readinesses = [];
    $scope.vacancies = [];
    $scope.br = {};


    //Sort function
       $scope.sortType  = 'secondName';
    $scope.sortReverse  = false;
    $scope.searchType   = '';

    var getApplicants = function () {
        ApiService.get('/cushing/applicants', function (data) {
            $scope.applicants = data.body;
            $scope.loading = false;
        }, function (br) {
            $scope.br = br;
        });
    }();

    var getOffices = function () {
        ApiService.get('/cushing/applicants/offices', function (data) {
            $scope.offices = data.body;
        });
    }();



    var getVacancies = function () {
        ApiService.get('/cushing/applicants/vacancies', function (data) {
            $scope.vacancies = data.body;
        });
    }();


    $scope.addApplicant = function () {
        ApiService.postJson('/cushing/applicants', $scope.newApplicant, function (data) {
            $scope.applicants.unshift(data.body);
            $scope.br = {};
            $scope.newApplicant = {};
            $("#modalAddApplicant").modal('hide');
          //  window.location.reload(true);
        }, function (br) {
            console.log(br);
            $scope.br = br;

        });
    };




    $scope.resetForm = function () {
        $scope.newApplicant = {};
        $scope.br = {};
    };
});
