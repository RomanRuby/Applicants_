app.controller('applicantCtrl', function ($scope, ApiService, $routeParams, $filter) {

    var id = $routeParams.id;

    $scope.newApplicant = {};
    $scope.applicants = [];
    $scope.applicant = {};
    $scope.interview = {};
    $scope.interviews = [];
    $scope.statuses = [];
    $scope.readinesses = [];
    $scope.br = {};

    $scope.newInterview = {};


    $scope.colors = ['#d5f4e6', '#80ced6', '#fefbd8', '#618685', '#e4d1d1', '#b9b0b0', '#d9ecd0', '#77a8a8'];

    var getApplicant = function () {
        ApiService.get('/cushing/applicants/' + id, function (data) {
            $scope.applicant = data.body;
        });
    }();


    $scope.getInterview = function () {
        ApiService.get('/cushing/interviews/byApplicant/'+id, function (data) {
            $scope.interviews = data.body;
        });
    }();


    var getStatuses = function () {
        ApiService.get('/cushing/interviews/statuses', function (data) {
            $scope.statuses = data.body;
        });

    }();


    $scope.deleteApplicant = function () {
        ApiService.delete('/cushing/applicants/' + id, $scope.applicant, function (data) {
            console.log(id);
            $scope.applicant = {};
            window.location.replace('http://localhost:8080/#/dashboard');
        });
    };

    $scope.updateApplicant = function () {
        ApiService.putJson('/cushing/applicants/' + id, $scope.applicant, function (data) {
            $scope.applicant = data.body;
        });
    };

    $scope.updateInterview = function () {
        ApiService.putJson('/cushing/interviews/byApplicant/' + id, $scope.interview, function (data) {
            $scope.interview = data.body;
        });
    };


    $scope.addInterview = function () {
        ApiService.postJson('/cushing/interviews/byApplicant/'+id, $scope.newInterview, function (data) {
            $scope.interviews.unshift(data.body);
            $scope.br = {};
            $scope.newInterview = {};

            $("#modalAddInterview").modal('hide');

        },function (br) {
            $scope.br = br;
        });
    };

    $scope.resetForm = function () {
        $scope.newRecord = {};
        $scope.newMeeting = {};
        $scope.colors=[];
        $scope.br = {};
    };


    $("#showColors").spectrum({
        color: " #d5f4e6",
        showPaletteOnly: true,
        hideAfterPaletteSelect:true,
        maxSelectionSize: 3,
        move: function(color){
            $('#selectcolor').css('background-color',color.toRgbString());
        },
        palette: ["rgb(230, 184, 175)", "rgb(244, 204, 204)", "rgb(252, 229, 205)", "rgb(255, 242, 204)", "rgb(217, 234, 211)",
            "rgb(208, 224, 227)", "rgb(201, 218, 248)", "rgb(207, 226, 243)", "rgb(217, 210, 233)", "rgb(234, 209, 220)",
            "rgb(234, 153, 153)", "rgb(249, 203, 156)", "rgb(255, 229, 153)", "rgb(182, 215, 168)",
            "rgb(162, 196, 201)", "rgb(164, 194, 244)", "rgb(159, 197, 232)", "rgb(180, 167, 214)", "rgb(213, 166, 189)",
            "rgb(246, 178, 107)", "rgb(255, 217, 102)", "rgb(147, 196, 125)",
            "rgb(118, 165, 175)", "rgb(109, 158, 235)", "rgb(111, 168, 220)", "rgb(142, 124, 195)", "rgb(194, 123, 160)"
        ]
    });

});