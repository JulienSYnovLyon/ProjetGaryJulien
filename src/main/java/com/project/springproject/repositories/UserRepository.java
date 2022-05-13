package com.project.springproject.repositories;

import org.springframework.stereotype.Repository;
import com.project.springproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}