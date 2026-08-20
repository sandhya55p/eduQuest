package com.eduquest.service;
import com.eduquest.entity.UserAchievement;

import java.util.List;

public interface UserAchievementService {
    List<UserAchievement> getAllUserAchievements();

    List<UserAchievement> getAchievementsByUser(Long userId);

}
