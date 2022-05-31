package com.project.springproject.services;

import com.project.springproject.entities.Roles;
import com.project.springproject.exceptions.ResourceNotFoundException;
import com.project.springproject.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    @Autowired
    private RolesRepository roleRepository;

    public Roles createOrUpdate(Roles roles) {
        return roleRepository.save(roles);
    }

    public Roles getUserById(Short id) throws ResourceNotFoundException {
        Optional<Roles> roles = roleRepository.findById(id);
        if (roles.isPresent()) {
            return roles.get();
        }
        throw new ResourceNotFoundException(Roles.class, id);
    }

    public List<Roles> getAllUsers() {
        return roleRepository.findAll();
    }

    public Page<Roles> getUsersWithPaging(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    public void deleteUser(String rolename) {
        roleRepository.deleteById(Short.valueOf(rolename));
    }
}
