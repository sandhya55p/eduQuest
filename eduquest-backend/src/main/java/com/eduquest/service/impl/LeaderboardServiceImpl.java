package com.eduquest.service.impl;

import com.eduquest.entity.Leaderboard;
import com.eduquest.repository.LeaderboardRepository;
import com.eduquest.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardServiceImpl implements LeaderboardService {
    @Autowired
    private LeaderboardRepository leaderboardRepository;

    @Override
    public Leaderboard createLeaderboard(Leaderboard leaderboard) {
        return leaderboardRepository.save(leaderboard);
    }

    @Override
    public List<Leaderboard> getAllLeaderboards() {
        return leaderboardRepository.findAll();
    }

    @Override
    public Leaderboard getLeaderboardById(Long id) {
        return leaderboardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leaderboard not found"));
    }

    @Override
    public Leaderboard updateLeaderboard(Long id, Leaderboard leaderboard) {

        Leaderboard existing = getLeaderboardById(id);

        existing.setTotalXP(leaderboard.getTotalXP());
        existing.setTotalCoins(leaderboard.getTotalCoins());
        existing.setTotalAchievements(leaderboard.getTotalAchievements());
        existing.setTotalBadges(leaderboard.getTotalBadges());
        existing.setCompletedLessons(leaderboard.getCompletedLessons());
        existing.setRankPosition(leaderboard.getRankPosition());
        existing.setUser(leaderboard.getUser());

        return leaderboardRepository.save(existing);
    }

    @Override
    public void deleteLeaderboard(Long id) {
        leaderboardRepository.deleteById(id);
    }

    @Override
    public Leaderboard getLeaderboardByUser(Long userId) {
        return leaderboardRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Leaderboard not found"));
    }
}
