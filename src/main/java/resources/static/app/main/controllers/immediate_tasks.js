app.controller('immediate_tasksCtrl', function ($scope, ApiService, $timeout, $location) {

    $scope.loading = true;
    $scope.interview = {};
    $scope.interviews = [];
    $scope.date = {};
    $scope.br = {};

    //Sort function
    $scope.sortType  = 'eventDate';
    $scope.sortReverse  = false;
    $scope.searchType   = '';


    var getInterviews = function () {
        ApiService.get('/cushing/interviews/immediate_interviews', function (data) {
            $scope.interviews = data.body;
            $scope.loading = false;
        });
    }();

    $scope.resetForm = function () {
        $scope.newApplicant = {};
        $scope.br = {};
    };

});
