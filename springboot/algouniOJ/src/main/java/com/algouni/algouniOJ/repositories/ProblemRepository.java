package com.algouni.algouniOJ.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algouni.algouniOJ.models.Difficulty;
import com.algouni.algouniOJ.models.Problem;

public interface ProblemRepository extends JpaRepository<Problem, Long> {

    List<Problem> findByDifficulty(Difficulty difficulty);
    // Spring Data JPA will provide the basic CRUD methods

} 
