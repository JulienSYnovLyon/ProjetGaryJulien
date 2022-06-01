package com.project.springproject.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.springproject.exceptions.ResourceNotFoundException;
import com.project.springproject.security.PasswordEncoderConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.springproject.entities.User;
import com.project.springproject.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoderConfig passwordEncoderConfig;

	public User createOrUpdate(User user) {
		if (StringUtils.isNotEmpty(user.getPassword())) {
			user.setPassword(passwordEncoderConfig.getEncoder().encode(user.getPassword()));
		}
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

	@Override
	public UserDetails loadUserByUsername(String mail) throws
			UsernameNotFoundException {
		User user = userRepository.findByMail(mail);
		if (user != null) {
			List<GrantedAuthority> authorities = new
					ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_" +
					user.getRole().getNom()));
			return new
					org.springframework.security.core.userdetails.User(user.getMail(),
					user.getPassword(),
					authorities);
		}
		throw new UsernameNotFoundException("User '" + mail + "' not found or inactive");
	}

	public void setPassword(String userName, String newPassword) {
		User user = userRepository.findById(Long.valueOf(userName)).get();
		String encodedNewPassword = passwordEncoderConfig.getEncoder().encode(newPassword);
		if (user != null) {
			user.setPassword(encodedNewPassword);
			userRepository.save(user);
		}
	}
}