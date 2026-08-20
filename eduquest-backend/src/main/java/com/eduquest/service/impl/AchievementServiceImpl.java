package com.eduquest.service.impl;

import com.eduquest.entity.Achievement;
import com.eduquest.repository.AchievementRepository;
import com.eduquest.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {
    @Autowired
    private AchievementRepository achievementRepository;
    @Override
    public Achievement createAchievement(Achievement achievement){
        return achievementRepository.save(achievement);
    }
    @Override
    public List<Achievement> getAllAchievements(){
        return  achievementRepository.findAll();
    }
    @Override
    public Achievement getAchievementById(Long id){
        return achievementRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Achivement not found"));
    }
    @Override
    public Achievement updateAchievement(Long id, Achievement achievement) {

        Achievement existing = getAchievementById(id);

        existing.setTitle(achievement.getTitle());
        existing.setDescription(achievement.getDescription());
        existing.setRequiredXP(achievement.getRequiredXP());
        existing.setRewardXP(achievement.getRewardXP());
        existing.setRewardCoins(achievement.getRewardCoins());
        existing.setBadgeIcon(achievement.getBadgeIcon());

        return achievementRepository.save(existing);
    }
    @Override
    public void deleteAchievement(Long id){
        achievementRepository.deleteById(id);
    }




}
