package com.eduquest.service.impl;
import com.eduquest.dto.LoginDTO;
import  com.eduquest.dto.LoginResponse;
import com.eduquest.dto.UserDTO;
import com.eduquest.entity.User;
import com.eduquest.exception.EmailAlreadyExistsException;
import com.eduquest.repository.UserRepository;
import com.eduquest.security.JwtUtil;
import  com.eduquest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public User register(UserDTO userDTO){
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user=new User();
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(userDTO.getRole());

        return userRepository.save(user);

    }


    @Override
    public LoginResponse login(LoginDTO loginDTO) {

        User user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(
                loginDTO.getPassword(),
                user.getPassword()))
        {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new LoginResponse(
                token,
                user.getEmail(),
                user.getRole()
        );
    }
}
