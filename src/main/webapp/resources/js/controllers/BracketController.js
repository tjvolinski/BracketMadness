'use strict';
var BracketController = function($scope, $http) {
	$scope.addBracket = function(bracket) {
        $http.post('bracket/addBracket/', bracket).success(function() {});
    };
	
	$scope.getBracket = function(bracket) {
        $http.post('bracket/getBracket/', bracket).success(function(rs) {
			 $scope.bracket = rs;
		});
    };
    
    $scope.updateBracket = function(bracket) {
        $http.post('bracket/updateBracket/', bracket).success(function() {});
    };
    
    $scope.deleteBracket = function(bracket) {
        $http.post('bracket/deleteBracket/', bracket).success(function() {
        	$scope.bracket = '';
        });
    };
    
    $scope.simulateMadness = function(simulation) {
        $http.post('bracket/simulateMadness/', simulation).success(function(players) {
        	$scope.players = players;
        });
    };
    
    $scope.getPercentComplete = function(simulationCount) {
    	if (simulationCount != null && simulationCount != ""){
			$http.get('bracket/getPercentComplete/').success(function(percentComplete) {
				$scope.percentComplete = percentComplete;
				if (percentComplete != "100%"){
					$scope.getPercentComplete(simulationCount);
				} else {
					$scope.resetPercentComplete();
				}
			});
		}
    };
    
    $scope.getResults = function(simulationCount) {
		$http.post('bracket/getResults/', simulationCount).success(function(players) {
			$scope.players = players;
		});
    };
    
    $scope.getPic = function(simulationCount) {
		$http.post('bracket/getPic/', simulationCount).success(function(pic) {
			$scope.pic = pic;
		});
    };
    
    $scope.getBanner = function(simulationCount) {
		$http.post('bracket/getBanner/', simulationCount).success(function(banner) {
			$scope.banner = banner;
		});
    };
    
     $scope.getNote = function(simulationCount) {
		$http.post('bracket/getNote/', simulationCount).success(function(note) {
			$scope.note = note;
		});
    };
    
    $scope.resetPercentComplete = function() {
        $http.post('bracket/resetPercentComplete/').success(function() {});
    };
};