mainApp.controller('mainController', function ($scope, $http) {

    $scope.sortArray = function () {
        $http.post('/sort', $scope.arrayForm).then(function (response) {
            $scope.beforeSort = response.data.beforeSort;
            $scope.sortedArray = response.data.sortedArray;
            $scope.timeComplexity = response.data.timeComplexity;
        });
    };

    $scope.mergeArrays = function () {
        $http.post('/merge', $scope.mergeForm).then(function (response) {
            $scope.mergedArray = response.data.mergedArray;
        });
    };
});