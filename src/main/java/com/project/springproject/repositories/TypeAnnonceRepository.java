package com.project.springproject.repositories;

import com.project.springproject.entities.TypeAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeAnnonceRepository  extends JpaRepository<TypeAnnonce, Short> {
}
