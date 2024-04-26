package com.algouni.algouniOJ.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algouni.algouniOJ.repositories.SubmissionRepository;

@Service
public class LeaderboardService {
    @Autowired
    private SubmissionRepository submissionRepository;

    // @Autowired
    // private RedisTemplate<String, Object> redisTemplate; // Assuming Redis is
    // used for caching

    private static final String LEADERBOARD_KEY = "leaderboard";

    // ... logic for calculateScore(User user)

    // public List<LeaderboardEntry> getGlobalLeaderboard() {
    // if (redisTemplate.hasKey(LEADERBOARD_KEY)) {
    // // Retrieve from cache...
    // } else {
    // List<LeaderboardEntry> leaderboard = calculateLeaderboard(); // Query
    // database
    // // ... store in cache ...;
    // return leaderboard;
    // }
    // }

    // private List<LeaderboardEntry> calculateLeaderboard() {
    // // ... Query submissions, aggregate scores, sort, etc.
    // }
}
