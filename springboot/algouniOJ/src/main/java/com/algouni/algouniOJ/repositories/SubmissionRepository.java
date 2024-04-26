package com.algouni.algouniOJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algouni.algouniOJ.models.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Long> { 
}
