app.service('ApiService', ['$http', function($http) {

    var baseHeaders = {};

    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
    var csrfToken = $("meta[name='_csrf']").attr("content");
    baseHeaders[csrfHeader] = csrfToken;

    //////////////////////////////////////////

    var onSuccess = function (cb) {
        return function(data) {
            console.log(data.data);
            cb(data.data);
        }
    };

    var onError = function (eb) {
        return function (response) {
            if (!response.data) {
                notification('error', 'Неизвестная проблема. Обновите страницу.', 5000);
                return;
            }

            if (!eb) {
                notification('warning', response.data.message, 5000);
                return;
            }

            var data = response.data;

            var br = {};
            if (data.errors && data.errors.length) {
                for (var i = 0; i < data.errors.length; i++) {
                    var error = data.errors[i];
                    br[error.field] = error.defaultMessage;
                }
            }

            eb(br);
        }
    };

    //////////////////////////////////////////

    this.getHeaders = function (contentType) {
        var headers = _.clone(baseHeaders);
        if (contentType) headers['Content-Type'] = contentType;
        return headers;
    };

    this.get = function (url, cb, eb) {
        return $http.get(url).then(onSuccess(cb), onError(eb));
    };

    this.post = function (url, data, cb, eb) {
        return $http({
            method: 'POST',
            url: url,
            headers: this.getHeaders('application/x-www-form-urlencoded'),
            transformRequest: function (obj) {
                var str = [];
                for (var p in obj) {
                    str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                }
                return str.join("&");
            },
            data:    data
        }).then(onSuccess(cb), onError(eb));
    };
    
    this.delete = function (url, data, cb, eb) {
        return $http({
            method: 'DELETE',
            url: url,
            headers: this.getHeaders('application/x-www-form-urlencoded'),
            transformRequest: function (obj) {
                var str = [];
                for (var p in obj) {
                    str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                }
                return str.join("&");
            },
            data: data
        }).then(onSuccess(cb), onError(eb));
    };

    this.postJson = function (url, data, cb, eb) {
        return $http({
            method: 'POST',
            url: url,
            headers: this.getHeaders('application/json'),
            data: data
        }).then(onSuccess(cb), onError(eb));
    };

    this.putJson = function (url, data, cb, eb) {
        return $http({
            method: 'PUT',
            url: url,
            headers: this.getHeaders('application/json'),
            data: data
        }).then(onSuccess(cb), onError(eb));
    };

}]);