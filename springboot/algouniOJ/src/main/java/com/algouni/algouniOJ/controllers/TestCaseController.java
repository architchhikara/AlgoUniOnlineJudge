package com.algouni.algouniOJ.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize; // Example - use your auth mechanism
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algouni.algouniOJ.models.Problem;
import com.algouni.algouniOJ.models.TestCase;
import com.algouni.algouniOJ.services.ProblemService;
import com.algouni.algouniOJ.services.TestCaseService;

@RestController
@RequestMapping("/api/problems")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    @Autowired
    private ProblemService problemService;

    // ... (Get Test Cases Endpoint - You already have this)

    @PostMapping("/{problemId}/testcases")
    // @PreAuthorize("hasRole('ADMIN')") // Protect with authorization
    public ResponseEntity<TestCase> addTestCase(@PathVariable Long problemId, @RequestBody TestCase testCase) {
        Problem problem = problemService.getProblemById(problemId);
        testCase.setProblem(problem);
        TestCase savedTestCase = testCaseService.saveTestCase(testCase);
        return new ResponseEntity<>(savedTestCase, HttpStatus.CREATED);
    }

    @PutMapping("/testcases/{testCaseId}")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TestCase> updateTestCase(@PathVariable Long testCaseId,
            @RequestBody TestCase updatedTestCase) {
        if (!testCaseService.findById(testCaseId).isPresent()) {
            // throw new NotFoundException("Test case not found");
        }
        updatedTestCase.setId(testCaseId); // Ensure ID is preserved
        return new ResponseEntity<>(testCaseService.saveTestCase(updatedTestCase), HttpStatus.OK);
    }

    @DeleteMapping("/testcases/{testCaseId}")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long testCaseId) {
        if (!testCaseService.findById(testCaseId).isPresent()) {
            // throw new NotFoundException("Test case not found");
        }
        testCaseService.deleteTestCase(testCaseId);
        return ResponseEntity.noContent().build();
    }

    // get all test cases
    @GetMapping("/testcases")
    public ResponseEntity<Iterable<TestCase>> getAllTestCases() {
        return new ResponseEntity<>(testCaseService.getAllTestCases(), HttpStatus.OK);
    }

}
