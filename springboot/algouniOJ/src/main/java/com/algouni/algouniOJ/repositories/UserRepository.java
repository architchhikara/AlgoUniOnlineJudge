package com.algouni.algouniOJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algouni.algouniOJ.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // Sample custom method
}
