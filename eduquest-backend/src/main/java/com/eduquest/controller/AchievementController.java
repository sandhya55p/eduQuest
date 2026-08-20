package com.eduquest.controller;

import com.eduquest.entity.Achievement;
import com.eduquest.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
@CrossOrigin(origins = "*")
public class AchievementController {
    @Autowired
    private AchievementService achievementService;
    @PostMapping
    public Achievement createAchievement(@RequestBody Achievement achievement){
        return achievementService.createAchievement(achievement);

        }
    @GetMapping
    public List<Achievement> getAllAchievements() {
        return achievementService.getAllAchievements();
    }
    @GetMapping("/{id}")
    public Achievement getAchievementsBYId(@PathVariable Long id){
        return achievementService.getAchievementById(id);
    }
    @PutMapping("/{id}")
    public Achievement updateAchievement(@PathVariable Long id,
                                         @RequestBody Achievement achievement){
        return achievementService.updateAchievement(id, achievement);
    }
    @DeleteMapping("/{id}")
    public String deleteAchievement(@PathVariable Long id) {
        achievementService.deleteAchievement(id);
        return "Achievement deleted successfully";
    }

}
