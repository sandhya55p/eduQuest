package com.eduquest.engine;

import com.eduquest.entity.Achievement;
import com.eduquest.entity.User;
import com.eduquest.entity.UserAchievement;
import com.eduquest.repository.AchievementRepository;
import com.eduquest.repository.UserAchievementRepository;
import com.eduquest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class AchievementEngine {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AchievementRepository achievementRepository;

    @Autowired
    private UserAchievementRepository userAchievementRepository;

    public void checkAchievements(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        List<Achievement> achievements = achievementRepository.findAll();

        for (Achievement achievement : achievements) {

            boolean alreadyUnlocked =
                    userAchievementRepository.existsByUserIdAndAchievementId(
                            userId,
                            achievement.getId());

            if (alreadyUnlocked) {
                continue;
            }

            switch (achievement.getAchievementType()) {

                case "XP":

                    if (user.getTotalXP() >= achievement.getTargetValue()) {
                        unlockAchievement(user, achievement);
                    }

                    break;

                case "COINS":

                    if (user.getTotalCoins() >= achievement.getTargetValue()) {
                        unlockAchievement(user, achievement);
                    }

                    break;

                case "LEVEL":

                    if (user.getLevel() >= achievement.getTargetValue()) {
                        unlockAchievement(user, achievement);
                    }

                    break;

                case "LESSON":

                    // We'll implement tomorrow
                    break;

                case "QUIZ":

                    // We'll implement tomorrow
                    break;

                case "STREAK":

                    // We'll implement tomorrow
                    break;

                default:
                    break;
            }
        }
    }

    /**
     * Unlock achievement
     */
    private void unlockAchievement(User user,
                                   Achievement achievement) {

        UserAchievement userAchievement = new UserAchievement();

        userAchievement.setUser(user);

        userAchievement.setAchievement(achievement);

        userAchievement.setUnlockedAt(LocalDateTime.now());

        userAchievementRepository.save(userAchievement);

        // Reward XP
        if (achievement.getRewardXP() != null) {

            user.setTotalXP(
                    user.getTotalXP()
                            + achievement.getRewardXP());
        }

        // Reward Coins
        if (achievement.getRewardCoins() != null) {

            user.setTotalCoins(
                    user.getTotalCoins()
                            + achievement.getRewardCoins());
        }

        userRepository.save(user);

        System.out.println("Achievement Unlocked : "
                + achievement.getTitle());
    }

}