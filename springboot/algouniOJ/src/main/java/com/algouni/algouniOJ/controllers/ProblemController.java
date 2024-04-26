package com.algouni.algouniOJ.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algouni.algouniOJ.models.Difficulty;
import com.algouni.algouniOJ.models.Problem;
import com.algouni.algouniOJ.services.ProblemService;

@RestController
@RequestMapping("/api/problems")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @GetMapping
    public List<Problem> getProblems(@RequestParam(required = false) Difficulty difficulty) {
        if (difficulty != null) {
            return problemService.getProblemsByDifficulty(difficulty);
        } else {
            return problemService.getAllProblems();
        }
    }

    @GetMapping("/{problemId}")
    public ResponseEntity<Problem> getProblem(@PathVariable Long problemId) {
        Problem problem = problemService.getProblemById(problemId);
        if (problem != null) {
            return ResponseEntity.ok(problem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
