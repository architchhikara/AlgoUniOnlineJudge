package com.algouni.algouniOJ.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algouni.algouniOJ.models.Difficulty;
import com.algouni.algouniOJ.models.Problem;
import com.algouni.algouniOJ.repositories.ProblemRepository;

@Service
public class ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }

    public Problem getProblemById(Long id) {
        return problemRepository.findById(id).orElse(null); // Handle potential not found case
    }

    public List<Problem> getProblemsByDifficulty(Difficulty difficulty) {
        return problemRepository.findByDifficulty(difficulty);
    }

    // ... add methods for saving problems, search, filtering, etc. 
}

