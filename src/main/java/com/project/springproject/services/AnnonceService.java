package com.project.springproject.services;

import com.project.springproject.entities.Annonces;
import com.project.springproject.exceptions.ResourceNotFoundException;
import com.project.springproject.repositories.AnnoncesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnonceService {

    @Autowired
    private AnnoncesRepository annoncesRepository;

    public Annonces createOrUpdate(Annonces annonces) {
        return annoncesRepository.save(annonces);
    }

    public Annonces getAnnonceById(Long annonces) throws ResourceNotFoundException {
        Optional<Annonces> annonce = annoncesRepository.findById(annonces);
        if (annonce.isPresent()) {
            return annonce.get();
        }
        throw new ResourceNotFoundException(Annonces.class, annonces);
    }

    public List<Annonces> getAllAnonces() {
        return annoncesRepository.findAll();
    }

    public Page<Annonces> getAnoncesWithPaging(Pageable pageable) {
        return annoncesRepository.findAll(pageable);
    }

    public void deleteAnnonce(String username) {
        annoncesRepository.deleteById(Long.valueOf(username));
    }
}
