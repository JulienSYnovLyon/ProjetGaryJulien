package com.project.springproject.services;

import com.project.springproject.entities.TypeAnnonce;
import com.project.springproject.exceptions.ResourceNotFoundException;
import com.project.springproject.repositories.TypeAnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeAnnonceService {

    @Autowired
    private TypeAnnonceRepository typeAnnoncesRepository;

    public TypeAnnonce createOrUpdate(TypeAnnonce user) {
        return typeAnnoncesRepository.save(user);
    }

    public TypeAnnonce getUserById(Short typeAnnonce) throws ResourceNotFoundException {
        Optional<TypeAnnonce> typeAnnonces = typeAnnoncesRepository.findById(typeAnnonce);
        if (typeAnnonces.isPresent()) {
            return typeAnnonces.get();
        }
        throw new ResourceNotFoundException(TypeAnnonce.class, typeAnnonce);
    }

    public List<TypeAnnonce> getAllUsers() {
        return typeAnnoncesRepository.findAll();
    }

    public Page<TypeAnnonce> getUsersWithPaging(Pageable pageable) {
        return typeAnnoncesRepository.findAll(pageable);
    }

    public void deleteUser(String username) {
        typeAnnoncesRepository.deleteById(Short.valueOf(username));
    }
}
