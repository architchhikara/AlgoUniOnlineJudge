package com.algouni.algouniOJ.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algouni.algouniOJ.services.LeaderboardService;

@RestController
@RequestMapping("/api/leaderboard")
public class LeaderboardController {
    @Autowired
    private LeaderboardService leaderboardService;

    // TODO: Implement the getLeaderboard method
    // This method should return the global leaderboard
    // The leaderboard should be sorted by score in descending order
    // The leaderboard should contain the username and score of each user
    // The leaderboard should contain at most 10 entries
    // The leaderboard should be cached for 1 minute
    // @Cacheable(value = "leaderboard", key = "'global'", sync = true)
    // @GetMapping
    // public List<LeaderboardEntry> getLeaderboard() {
    // return leaderboardService.getGlobalLeaderboard();
    // }
}
