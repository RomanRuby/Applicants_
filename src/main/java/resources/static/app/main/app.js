var notification = function (type, message, ttl) {
    // http://tympanus.net/codrops/2014/07/23/notification-styles-inspiration/

    var notification = new NotificationFx({
        message: '<p class="text-center">' + message + '</p>',
        layout: 'attached',
        effect: 'flip',
        type: type, // success, notice, warning, error
        ttl: ttl ? ttl : 2000
    });

    notification.show();
};

var app = angular.module('mainApp', [
    'ngRoute',
    'angular-loading-bar',
    'ngAnimate',
    'ngSanitize',
    'xeditable'
]);

app.config(['cfpLoadingBarProvider', function (cfpLoadingBarProvider) {
    cfpLoadingBarProvider.includeBar = true;
    cfpLoadingBarProvider.includeSpinner = true;
    cfpLoadingBarProvider.latencyThreshold = 100;
}]);

/**
 * Configure the Routes
 */
app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when("/", {
            redirectTo: '/immediate_tasks'
        })

        .when("/dashboard", {
            templateUrl: "/views/main/dashboard.html",
            controller: "dashboardCtrl",
            title: 'Обзорная'
        })

        .when("/applicants/:id", {
            templateUrl: "/views/main/applicant.html",
            controller: "applicantCtrl",
            title: 'Информация'
        })

        .when("/immediate_tasks", {
            templateUrl: "/views/main/immediate_tasks.html",
            controller: "immediate_tasksCtrl",
            title: 'Ближайшие События'
        })

        .when("/tasks", {
            templateUrl: "/views/main/tasks.html",
            controller: "tasksCtrl",
            title: 'События'
        })
        .when("/service", {
            templateUrl: "/views/main/service.html",
            controller: "serviceCtrl",
            title: 'Служебные'
        })
        .when("/parsing", {
            templateUrl: "/views/main/parsing.html",
            controller: "parsingCtrl",
            title: 'parsing'
        })


        .when("/error-404", {
            templateUrl: "/views/error-404.html",
            title: 'Ошибка 404'

        })

        .otherwise({
            redirectTo: '/error-404'
        });
}]);

app.run(['$location', '$rootScope', function ($location, $rootScope) {
    $rootScope.$on('$routeChangeSuccess', function (event, current, previous) {
        $rootScope.title = current.$$route.title;
    });
}]);

app.run(function (editableOptions, editableThemes) {
    editableThemes.bs3.buttonsClass = 'btn-sm';
    editableThemes.bs3.inputClass = 'input-sm';
    editableOptions.theme = 'bs3';
});

app.directive('bsNavbar', function ($window, $location) {

    var defaults = this.defaults = {
        activeClass: 'active',
        routeAttr: 'data-match-route',
        strict: true
    };

    return {
        restrict: 'A',
        link: function postLink(scope, element, attr, controller) {

            // Directive options
            var options = angular.copy(defaults);
            angular.forEach(Object.keys(defaults), function (key) {
                if (angular.isDefined(attr[key])) options[key] = attr[key];
            });

            // Watch for the $location
            scope.$watch(function () {

                return $location.path();

            }, function (newValue, oldValue) {

                var liElements = element[0].querySelectorAll('li[' + options.routeAttr + '],li > a[' + options.routeAttr + ']');

                angular.forEach(liElements, function (li) {

                    var liElement = angular.element(li);
                    var pattern = liElement.attr(options.routeAttr).replace('/', '\\/');
                    if (options.strict) {
                        pattern = '^' + pattern;
                    }
                    var regexp = new RegExp(pattern, ['i']);

                    if (regexp.test(newValue)) {
                        liElement.addClass(options.activeClass);
                    } else {
                        liElement.removeClass(options.activeClass);
                    }

                });
            });

        }

    };
});

