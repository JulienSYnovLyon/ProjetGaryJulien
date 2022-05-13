package com.project.springproject.repositories;

import com.project.springproject.entities.Alertes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertesRepository  extends JpaRepository<Alertes, Long> {
}