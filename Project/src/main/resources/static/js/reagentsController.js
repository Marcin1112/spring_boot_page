demo
		.controller('reagentsController',
				function($scope, $rootScope, $http) {
					$scope.checkboxModel = {
						organic_box : true,
						fume_hood : true,
						inorganic_box : true,
						freezer : true
					};

					$scope.filterBox = function(reagent) {
						return function(p) {
							if (p.box.name == 'lodówka'
									&& $scope.checkboxModel.freezer) {
								return true;
							} else if (p.box.name == 'wyciąg'
									&& $scope.checkboxModel.fume_hood) {
								return true;
							} else if (p.box.name == 'szafa nieorganiczna'
									&& $scope.checkboxModel.inorganic_box) {
								return true;
							} else if (p.box.name == 'szafa organiczna'
									&& $scope.checkboxModel.organic_box) {
								return true;
							}
						};
					};

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