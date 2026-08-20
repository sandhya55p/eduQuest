package com.eduquest.service;

import com.eduquest.entity.Leaderboard;

import java.util.List;

public interface LeaderboardService {
    Leaderboard createLeaderboard(Leaderboard leaderboard);

    List<Leaderboard> getAllLeaderboards();

    Leaderboard getLeaderboardById(Long id);

    Leaderboard updateLeaderboard(Long id, Leaderboard leaderboard);

    void deleteLeaderboard(Long id);

    Leaderboard getLeaderboardByUser(Long userId);
}
