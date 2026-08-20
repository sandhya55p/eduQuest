package com.eduquest.controller;

import com.eduquest.entity.UserAchievement;
import com.eduquest.service.UserAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-achievements")
@CrossOrigin(origins = "*")
public class UserAchievementController {
    @Autowired
    private UserAchievementService userAchievementService;
    @GetMapping
    public List<UserAchievement> getAllAchievements(){
        return userAchievementService.getAllUserAchievements();
    }
    @GetMapping("/user/{userId}")
    public List<UserAchievement> getUserAchievements(@PathVariable Long userId) {
        return userAchievementService.getAchievementsByUser(userId);
    }
}
