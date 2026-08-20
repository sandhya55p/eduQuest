package com.eduquest.engine;

import com.eduquest.entity.User;
import com.eduquest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LevelEngine {
    @Autowired
    private UserRepository userRepository;

    public void updateLevel(Long userId){
        User user =userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found"));
        int xp=user.getTotalXP();
        int level;
        if(xp<100)
            level=1;
        else if(xp<250)
            level=2;
        else if(xp<500)
            level=3;
        else if(xp<800)
            level=4;
        else if(xp<1200)
            level=5;
        else
            level=(xp/500)+3;
        user.setLevel(level);
        userRepository.save(user);

    }
}
