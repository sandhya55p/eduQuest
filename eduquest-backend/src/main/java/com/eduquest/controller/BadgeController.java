package com.eduquest.controller;

import com.eduquest.entity.Badge;
import com.eduquest.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/badges")
@CrossOrigin(origins = "*")
public class BadgeController {
    @Autowired
    private BadgeService badgeService;

    @PostMapping
    public Badge createBadge(@RequestBody Badge badge){
        return badgeService.createBadge(badge);
    }

    @GetMapping
    public List<Badge> getAllBadges(){
        return badgeService.getAllBadges();
    }
    @GetMapping("/{id}")
    public Badge getBadgeById(@PathVariable Long id){
        return badgeService.getBadgeById(id);

    }
    @PutMapping("/{id}")
    public Badge updateBadge(@PathVariable Long id,
                             @RequestBody Badge badge) {
        return badgeService.updateBadge(id, badge);
    }
    @DeleteMapping("/{id}")
    public String deleteBadge(@PathVariable Long id) {
        badgeService.deleteBadge(id);
        return "Badge deleted successfully";
    }
    @GetMapping("/user/{userId}")
    public List<Badge> getBadgesByUser(@PathVariable Long userId) {

        return badgeService.getBadgesByUser(userId);
    }
}
