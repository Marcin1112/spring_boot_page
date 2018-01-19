demo.controller('reagentNewController', function($scope, $rootScope, $http) {
	$http({
		method : 'GET',
		url : '/rest/box'
	}).then(function(response) {
		temporaryReagents = response.data;
		if (temporaryReagents.indexOf("<div") != -1) {
			$scope.reagent = "Niezalogowano";
			$scope.logged = false;
		} else {
			$scope.box = temporaryReagents;
			$scope.logged = true;
		}
	});
});