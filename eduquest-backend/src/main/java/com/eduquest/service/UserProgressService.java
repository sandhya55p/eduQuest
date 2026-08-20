package com.eduquest.service;

import com.eduquest.engine.RewardEngine;
import com.eduquest.entity.UserProgress;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserProgressService {

    UserProgress saveProgress(UserProgress userProgress);

    List<UserProgress> getAllProgress();

    UserProgress getProgressById(Long id);

    UserProgress updateProgress(Long id, UserProgress userProgress);

    void deleteProgress(Long id);

    List<UserProgress> getProgressByUser(Long userId);

    List<UserProgress> getProgressByLesson(Long lessonId);

    UserProgress addXp(Long id, Integer xp);

    UserProgress addCoins(Long id, Integer coins);

    UserProgress updateLevel(Long id);
}
