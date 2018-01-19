demo.controller('reagentsController', function($scope, $rootScope, $http) {
	$http({
		method : 'GET',
		url : '/rest/reagents'
	}).then(function(response) {
		temporaryReagents = response.data;
		if (temporaryReagents.indexOf("<div") != -1) {
			$scope.reagents = "Niezalogowano";
			$scope.logged = false;
		} else {
			$scope.reagents = temporaryReagents;
			$scope.logged = true;
		}
	});
});