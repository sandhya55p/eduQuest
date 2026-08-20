package com.eduquest.engine;

import com.eduquest.entity.User;
import com.eduquest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class XPManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LevelEngine levelEngine;

    public void addXP(Long userId, Integer xp) {

        if (xp == null || xp <= 0) {
            throw new IllegalArgumentException(
                    "XP must be greater than zero");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if (user.getTotalXP() == null) {
            user.setTotalXP(0);
        }

        user.setTotalXP(
                user.getTotalXP() + xp
        );

        userRepository.save(user);

        // Recalculate level
        levelEngine.updateLevel(userId);
    }
}