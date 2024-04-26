package com.algouni.algouniOJ.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algouni.algouniOJ.models.Problem;
import com.algouni.algouniOJ.models.TestCase;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

    // TODO Test this
    List<TestCase> findByProblemId(Problem problem); 
}
