package com.project.springproject.services;

import com.project.springproject.entities.Alertes;
import com.project.springproject.exceptions.ResourceNotFoundException;
import com.project.springproject.repositories.AlertesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlerteService {

    @Autowired
    private AlertesRepository alertesRepository;

    public Alertes createOrUpdate(Alertes alertes) {
        return alertesRepository.save(alertes);
    }

    public Alertes getUserById(Long alerte) throws ResourceNotFoundException {
        Optional<Alertes> alertes = alertesRepository.findById(alerte);
        if (alertes.isPresent()) {
            return alertes.get();
        }
        throw new ResourceNotFoundException(Alertes.class, alerte);
    }

    public List<Alertes> getAllUsers() {
        return alertesRepository.findAll();
    }

    public Page<Alertes> getUsersWithPaging(Pageable pageable) {
        return alertesRepository.findAll(pageable);
    }

    public void deleteUser(String username) {
        alertesRepository.deleteById(Long.valueOf(username));
    }
}
