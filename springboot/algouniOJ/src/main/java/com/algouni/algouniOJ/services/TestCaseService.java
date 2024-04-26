package com.algouni.algouniOJ.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algouni.algouniOJ.models.Problem;
import com.algouni.algouniOJ.models.TestCase;
import com.algouni.algouniOJ.repositories.TestCaseRepository;

@Service
public class TestCaseService {
    @Autowired
    private TestCaseRepository testCaseRepository;

    @Autowired
    private ProblemService problemService;

    public List<TestCase> findTestCasesByProblemId(Long problemId) {
        Problem problem = problemService.getProblemById(problemId);
        return testCaseRepository.findByProblemId(problem);
    }

    public TestCase saveTestCase(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }

    public Optional<TestCase> findById(Long testCaseId) {
        return testCaseRepository.findById(testCaseId);
    }

    public void deleteTestCase(Long testCaseId) {
        testCaseRepository.deleteById(testCaseId);
    }

    public List<TestCase> getAllTestCases() {
        return testCaseRepository.findAll();
    }
}
