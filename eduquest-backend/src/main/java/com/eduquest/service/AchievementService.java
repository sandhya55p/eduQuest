package com.eduquest.service;

import com.eduquest.entity.Achievement;

import java.util.List;

public interface AchievementService {
    Achievement createAchievement(Achievement achievement);
    List<Achievement> getAllAchievements();
    Achievement getAchievementById(Long id);
    Achievement updateAchievement(Long id , Achievement achievement);
    void deleteAchievement(Long id);

}
