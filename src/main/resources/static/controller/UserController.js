angular.module('myApp').controller('UserController',UserController);

function UserController($scope,UserFactory){
	
	$("#formEdit").hide();
	$("#formAdd").show();
	$scope.currentUser = {};
	$scope.newUser = {};
	
	allUsers();
	
	function allUsers(){
		UserFactory.getUsers().then(function(response){
			$scope.users = response;
		});
	}
	
	
	$scope.addUser = function(user){
		UserFactory.addUser(user).then(function(){
			allUsers();
		});
		console.log("User added");
		$scope.newUser = {};
	}
	
	$scope.deleteUser = function (id){
		var index = $scope.users.indexOf(id);
		UserFactory.deleteUser(id).then(function(){
			allUsers();
		});
		console.log("User deleted!")
	}
	
	$scope.editUser = function(user){
		$scope.currentUser = user;
		console.log("Current user is the user with id " + user.id);
		$("#formEdit").show();
		$("#formAdd").hide();
	}
	
	$scope.updateUser = function(user){
		var index = $scope.users.indexOf(user.id);
		UserFactory.updateUser(user);
		$("#formEdit").hide();
		$("#formAdd").show();
	}
	
}