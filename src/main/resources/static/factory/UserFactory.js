angular.module('myApp').factory('UserFactory',UserFactory);

function UserFactory($http){
	return{
		getUsers : getUsers,
		addUser: addUser,
		deleteUser: deleteUser,
		updateUser : updateUser
	};

function getUsers(){
	return $http.get('http://localhost:8080/users').then(complete).catch(failed);
}

function addUser(user){
	return $http({
		method: 'POST',
		url: 'http://localhost:8080/users',
		headers: {"Content-Type": "application/json;charset=UTF-8"},
		data: user
	});
}

function updateUser(user){
	$http({
		method : 'PUT',
		url: "http://localhost:8080/users/update/" + user.id,
		headers: {"Content-Type": "application/json;charset=UTF-8"},
		data : user
	});
}

function deleteUser(id){
	return $http({
		method: 'DELETE',
		url: 'http://localhost:8080/users/delete/' + id
	});
}

function complete(response){
	return response.data;
}

function failed(erorr){
	return error.statusText;
}

}