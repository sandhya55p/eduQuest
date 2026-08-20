package com.eduquest.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RewardEngine {

    @Autowired
    private XPManager xpManager;

    @Autowired
    private CoinManager coinManager;

    @Autowired
    private AchievementEngine achievementEngine;

    @Autowired
    private BadgeEngine badgeEngine;

    @Autowired
    private LeaderboardEngine leaderboardEngine;

    @Autowired
    private StreakEngine streakEngine;

    public void rewardUser(
            Long userId,
            Integer xp,
            Integer coins) {

        // 1. Add XP
        xpManager.addXP(userId, xp);

        // 2. Add coins
        coinManager.addCoins(userId, coins);

        // 3. Check achievements
        achievementEngine.checkAchievements(userId);

        // 4. Check badges
        badgeEngine.checkBadges(userId);

        // 5. Update leaderboard
        leaderboardEngine.updateLeaderboard(userId);

        // 6. Update streak
        streakEngine.updateStreak(userId);
    }
}