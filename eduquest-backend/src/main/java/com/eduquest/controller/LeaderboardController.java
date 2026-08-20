package com.eduquest.controller;

import com.eduquest.entity.Leaderboard;
import com.eduquest.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
@CrossOrigin(origins = "*")
public class LeaderboardController {
    @Autowired
    private LeaderboardService leaderboardService;

    @PostMapping
    public Leaderboard createLeaderboard(@RequestBody Leaderboard leaderboard) {
        return leaderboardService.createLeaderboard(leaderboard);
    }

    @GetMapping
    public List<Leaderboard> getAllLeaderboards() {
        return leaderboardService.getAllLeaderboards();
    }

    @GetMapping("/{id}")
    public Leaderboard getLeaderboardById(@PathVariable Long id) {
        return leaderboardService.getLeaderboardById(id);
    }

    @PutMapping("/{id}")
    public Leaderboard updateLeaderboard(@PathVariable Long id,
                                         @RequestBody Leaderboard leaderboard) {
        return leaderboardService.updateLeaderboard(id, leaderboard);
    }

    @DeleteMapping("/{id}")
    public String deleteLeaderboard(@PathVariable Long id) {
        leaderboardService.deleteLeaderboard(id);
        return "Leaderboard deleted successfully";
    }

    @GetMapping("/user/{userId}")
    public Leaderboard getLeaderboardByUser(@PathVariable Long userId) {
        return leaderboardService.getLeaderboardByUser(userId);
    }

}
