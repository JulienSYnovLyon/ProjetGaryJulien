package com.project.springproject.services;

import java.util.List;
import java.util.Optional;

import com.project.springproject.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.springproject.entities.User;
import com.project.springproject.repositories.UserRepository;

@Service
public class UserService  {
	@Autowired
	private UserRepository userRepository;

	public User createOrUpdate(User user) {
		return userRepository.save(user);
	}

	public User getUserById(Long username) throws ResourceNotFoundException {
		Optional<User> user = userRepository.findById(username);
		if (user.isPresent()) {
			return user.get();
		}
		throw new ResourceNotFoundException(User.class, username);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Page<User> getUsersWithPaging(Pageable pageable) {
		return userRepository.findAll(pageable);
	}
	
	public void deleteUser(String username) {
		userRepository.deleteById(Long.valueOf(username));
	}
}