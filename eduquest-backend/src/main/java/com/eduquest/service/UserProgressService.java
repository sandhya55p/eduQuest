package com.eduquest.service;

import com.eduquest.entity.UserProgress;

import java.util.List;

public interface UserProgressService {
    UserProgress saveProgress(UserProgress userProgress);
    List<UserProgress> getAllProgress();
    UserProgress getProgressById(Long id);
    UserProgress updateProgress(Long id, UserProgress userProgress);
    void deleteProgress(Long id);
    List<UserProgress> getProgressByUser(Long userId);

    List<UserProgress> getProgressByLesson(Long lessonId);
}

