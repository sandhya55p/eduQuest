package com.eduquest.controller;

import com.eduquest.entity.UserProgress;
import com.eduquest.service.UserProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin(origins = "*")
public class UserProgressController {
    @Autowired
    private UserProgressService userProgressService;
    @PostMapping
    public UserProgress saveProgress(@RequestBody UserProgress progress) {
        return userProgressService.saveProgress(progress);
    }

    @GetMapping
    public List<UserProgress> getAllProgress() {
        return userProgressService.getAllProgress();
    }

    @GetMapping("/{id}")
    public UserProgress getProgressById(@PathVariable Long id) {
        return userProgressService.getProgressById(id);
    }

    @PutMapping("/{id}")
    public UserProgress updateProgress(@PathVariable Long id,
                                       @RequestBody UserProgress progress) {
        return userProgressService.updateProgress(id, progress);
    }

    @DeleteMapping("/{id}")
    public String deleteProgress(@PathVariable Long id) {
        userProgressService.deleteProgress(id);
        return "Progress deleted successfully";
    }

    @GetMapping("/user/{userId}")
    public List<UserProgress> getProgressByUser(@PathVariable Long userId) {
        return userProgressService.getProgressByUser(userId);
    }

    @GetMapping("/lesson/{lessonId}")
    public List<UserProgress> getProgressByLesson(@PathVariable Long lessonId) {
        return userProgressService.getProgressByLesson(lessonId);
    }

    @PutMapping("/{id}/xp/{xp}")
    public  UserProgress addXp(@PathVariable Long id,
                               @PathVariable Integer xp){
        return  userProgressService.addXp(id,xp);
    }
    @PutMapping("/{id}/coins/{coins}")
    public UserProgress addCoins(@PathVariable Long id,
                                 @PathVariable Integer coins) {
        return userProgressService.addCoins(id, coins);
    }

    @PutMapping("/{id}/level")
    public UserProgress updateLevel(@PathVariable Long id) {
        return userProgressService.updateLevel(id);
    }

}
