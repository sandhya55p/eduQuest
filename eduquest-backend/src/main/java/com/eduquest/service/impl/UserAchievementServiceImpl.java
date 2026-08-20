package com.eduquest.service.impl;

import com.eduquest.entity.UserAchievement;
import com.eduquest.repository.UserAchievementRepository;
import com.eduquest.service.UserAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAchievementServiceImpl implements UserAchievementService {
    @Autowired
    private UserAchievementRepository userAchievementRepository;

    @Override
    public List<UserAchievement> getAllUserAchievements() {
        return userAchievementRepository.findAll();
    }

    @Override
    public List<UserAchievement> getAchievementsByUser(Long userId) {
        return userAchievementRepository.findByUserId(userId);
    }
}
