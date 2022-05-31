package com.project.springproject.controller;

import java.util.List;

import com.project.springproject.exceptions.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.springproject.entities.User;
import com.project.springproject.services.UserService;

import io.swagger.v3.oas.annotations.Operation;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/{id_users}", method = RequestMethod.GET)
	public User get(@PathVariable(name = "id_users") Long username) throws ResourceNotFoundException {
		return userService.getUserById(username);
	}

	@Operation(summary = "Récupération d'un utilisateur à partir de son identifiant")
	@ApiResponse(responseCode = "404", description = "Utilisateur non trouvé")
	@RequestMapping(method = RequestMethod.PUT)
	public User createOrUpdate(@RequestBody @Valid User user) {
		return userService.createOrUpdate(user);
	}

	@Operation(summary = "Récupération de tous les utilisateurs")
	@RequestMapping(path = "/_all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(path = "/{id_users}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable(name = "id_users") String username) {
		userService.deleteUser(username);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Page<User> getUsers(Pageable pageable) {
		return userService.getUsersWithPaging(pageable);
	}
}
