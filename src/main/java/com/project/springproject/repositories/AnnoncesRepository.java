package com.project.springproject.repositories;

import com.project.springproject.entities.Annonces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnoncesRepository  extends JpaRepository<Annonces, Long> {
}