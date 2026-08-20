package com.eduquest.service.impl;
import com.eduquest.engine.RewardEngine;
import com.eduquest.entity.UserProgress;
import com.eduquest.repository.UserProgressRepository;
import com.eduquest.service.UserProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProgressServiceImpl implements UserProgressService {

    @Autowired
    private UserProgressRepository userProgressRepository;
    @Autowired
    private RewardEngine rewardEngine;

    @Override
    public UserProgress saveProgress(UserProgress progress) {

        Long userId = progress.getUser().getId();
        Long lessonId = progress.getLesson().getId();

        Optional<UserProgress> existingProgress =
                userProgressRepository.findByUserIdAndLessonId(
                        userId,
                        lessonId
                );

        // If progress already exists for this user + lesson
        if (existingProgress.isPresent()) {

            UserProgress existing = existingProgress.get();

            // If reward was already given, don't give it again
            if (Boolean.TRUE.equals(existing.getRewardClaimed())) {
                return existing;
            }

            existing.setCompleted(progress.getCompleted());
            existing.setQuizScore(progress.getQuizScore());
            existing.setXp(progress.getXp());
            existing.setCoins(progress.getCoins());
            existing.setLevel(progress.getLevel());
            existing.setCompletedAt(progress.getCompletedAt());

            UserProgress saved = userProgressRepository.save(existing);

            if (Boolean.TRUE.equals(saved.getCompleted())) {

                Integer xp = saved.getXp() == null ? 0 : saved.getXp();
                Integer coins = saved.getCoins() == null ? 0 : saved.getCoins();

                if (xp > 0 || coins > 0) {

                    rewardEngine.rewardUser(
                            userId,
                            xp,
                            coins
                    );

                    saved.setRewardClaimed(true);

                    return userProgressRepository.save(saved);
                }
            }

            return saved;
        }

        // First time this user is saving this lesson
        progress.setRewardClaimed(false);

        UserProgress savedProgress =
                userProgressRepository.save(progress);

        if (Boolean.TRUE.equals(savedProgress.getCompleted())) {

            Integer xp = savedProgress.getXp() == null
                    ? 0
                    : savedProgress.getXp();

            Integer coins = savedProgress.getCoins() == null
                    ? 0
                    : savedProgress.getCoins();

            if (xp > 0 || coins > 0) {

                rewardEngine.rewardUser(
                        userId,
                        xp,
                        coins
                );

                savedProgress.setRewardClaimed(true);

                return userProgressRepository.save(savedProgress);
            }
        }

        return savedProgress;
    }

    @Override
    public List<UserProgress> getAllProgress() {
        return userProgressRepository.findAll();
    }

    @Override
    public UserProgress getProgressById(Long id) {
        return userProgressRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Progress not found with id: " + id));
    }

    @Override
    public UserProgress updateProgress(Long id, UserProgress progress) {

        UserProgress existing = getProgressById(id);

        existing.setUser(progress.getUser());
        existing.setLesson(progress.getLesson());
        existing.setCompleted(progress.getCompleted());
        existing.setQuizScore(progress.getQuizScore());
        existing.setXp(progress.getXp());
        existing.setCoins(progress.getCoins());
        existing.setLevel(progress.getLevel());
        existing.setCompletedAt(progress.getCompletedAt());

        return userProgressRepository.save(existing);
    }

    @Override
    public void deleteProgress(Long id) {
        UserProgress progress = getProgressById(id);
        userProgressRepository.delete(progress);
    }

    @Override
    public List<UserProgress> getProgressByUser(Long userId) {
        return userProgressRepository.findByUserId(userId);
    }

    @Override
    public List<UserProgress> getProgressByLesson(Long lessonId) {
        return userProgressRepository.findByLessonId(lessonId);
    }

    @Override
    public UserProgress addXp(Long id, Integer xp) {

        UserProgress progress = getProgressById(id);

        if (xp == null || xp < 0) {
            throw new IllegalArgumentException(
                    "XP must be a positive value");
        }

        if (progress.getXp() == null) {
            progress.setXp(0);
        }

        progress.setXp(progress.getXp() + xp);

        progress.setLevel(
                (progress.getXp() / 100) + 1
        );

        return userProgressRepository.save(progress);
    }

    @Override
    public UserProgress addCoins(Long id, Integer coins) {

        UserProgress progress = getProgressById(id);

        if (coins == null || coins < 0) {
            throw new IllegalArgumentException(
                    "Coins must be a positive value");
        }

        if (progress.getCoins() == null) {
            progress.setCoins(0);
        }

        progress.setCoins(
                progress.getCoins() + coins
        );

        return userProgressRepository.save(progress);
    }

    @Override
    public UserProgress updateLevel(Long id) {

        UserProgress progress = getProgressById(id);

        if (progress.getXp() == null) {
            progress.setXp(0);
        }

        progress.setLevel(
                (progress.getXp() / 100) + 1
        );

        return userProgressRepository.save(progress);
    }
}