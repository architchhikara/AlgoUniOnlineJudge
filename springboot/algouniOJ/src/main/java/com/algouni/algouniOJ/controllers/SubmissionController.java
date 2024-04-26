package com.algouni.algouniOJ.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algouni.algouniOJ.models.Submission;
import com.algouni.algouniOJ.models.User;
import com.algouni.algouniOJ.services.SubmissionService;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;

    @PostMapping
    public ResponseEntity<Submission> submitCode(@RequestBody Submission submission) {
        // @AuthenticationPrincipal User user // Assuming authentication in place

        // submission.setUser(user); // Associate submission with the logged-in user
        Submission savedSubmission = submissionService.submitCode(submission);
        return ResponseEntity.created(generateSubmissionURI(savedSubmission.getId())).body(savedSubmission);
    }

    // Helper method (optional)
    private URI generateSubmissionURI(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }
}
