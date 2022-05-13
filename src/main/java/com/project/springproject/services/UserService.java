package com.project.springproject.services;

import com.project.springproject.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.springproject.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createOrUpdate(User user) {
        return userRepository.save(user);
    }
    public User getUserById(Long idUsers) {
        return userRepository.findById(idUsers).orElse(null);
    }

}
