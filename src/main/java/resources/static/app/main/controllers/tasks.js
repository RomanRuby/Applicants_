app.controller('tasksCtrl', function ($scope, ApiService, $timeout, $location) {

    $scope.loading = true;

    $scope.interview = {};
    $scope.interviews = [];

    $scope.br = {};

    //Sort function
    $scope.sortType  = 'secondName';
    $scope.sortReverse  = false;
    $scope.searchType   = '';

    var getInterviews = function () {
        ApiService.get('/cushing/interviews', function (data) {
            $scope.interviews = data.body;
            $scope.loading = false;
        });
    }();

});
