package com.algouni.algouniOJ.services;

import org.springframework.stereotype.Service;

import com.algouni.algouniOJ.models.Submission;
import com.algouni.algouniOJ.models.Verdict;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//TODO Implement the class
@Service
public class CodeExecutionService {

    public Verdict executeCode(Submission submission) {
        // ... (Container setup, input/output handling)
        try {
            Process process = Runtime.getRuntime().exec(new String[] {"docker", "run", "--rm", "-m", "64m", "--cpus", "0.5", "pythonimage", "python", "codefile.py"}); // Replace with appropriate command

            boolean timeout = !process.waitFor(5, TimeUnit.SECONDS); // 5 second timeout

            // ... Read output, check for errors, check timeout

            return Verdict.ACCEPTED;
            // return determineVerdict(/* based on results */);

        } catch (IOException | InterruptedException e) {
            //Add TimeOutException

            // Log the error
            return Verdict.RUNTIME_ERROR;
        } finally {
            // ... Cleanup
        }
    }
}
