package com.eduquest.engine;

import com.eduquest.entity.User;
import com.eduquest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoinManager {

    @Autowired
    private UserRepository userRepository;

    public void addCoins(Long userId, Integer coins) {

        if (coins == null || coins <= 0) {
            throw new IllegalArgumentException(
                    "Coins must be greater than zero");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if (user.getTotalCoins() == null) {
            user.setTotalCoins(0);
        }

        user.setTotalCoins(
                user.getTotalCoins() + coins
        );

        userRepository.save(user);
    }
}