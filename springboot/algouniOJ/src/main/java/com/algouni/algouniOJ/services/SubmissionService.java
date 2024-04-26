package com.algouni.algouniOJ.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algouni.algouniOJ.models.Submission;
import com.algouni.algouniOJ.models.Verdict;
import com.algouni.algouniOJ.repositories.SubmissionRepository;

@Service
public class SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired 
    private CodeExecutionService codeExecutionService; // Assuming you have a service for this

    public Submission submitCode(Submission submission) {
        Verdict verdict = codeExecutionService.executeCode(submission);
        submission.setVerdict(verdict);
        return submissionRepository.save(submission);
    }
}
