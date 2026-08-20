package com.eduquest.controller;

import com.eduquest.engine.RewardEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reward")
public class RewardTestController {
    @Autowired
    private RewardEngine rewardEngine;
    @PostMapping("/{userId}")
    public String rewardUser(@PathVariable Long userId) {

        rewardEngine.rewardUser(userId, 100, 50);

        return "Reward Added Successfully";
    }
}
