demo.controller('reagentDeleteController', function($scope, $rootScope, $http) {
	$scope.aaa = '/rest/reagents/' + $rootScope.data.reagent;
	$http({
		method : 'GET',
		url : '/rest/reagents/' + $rootScope.data.reagent
	}).then(function(response) {
		temporaryReagents = response.data;
		if (temporaryReagents.indexOf("<div") != -1) {
			$scope.reagent = "Niezalogowano";
			$scope.logged = false;
		} else {
			$scope.reagent = temporaryReagents;
			$scope.logged = true;
		}
	});
});