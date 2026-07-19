package com.eduquest.service;
import com.eduquest.dto.LoginDTO;
import com.eduquest.dto.LoginResponse;
import  com.eduquest.dto.UserDTO;
import  com.eduquest.entity.User;

public interface UserService {

    User register(UserDTO userDTO);
    LoginResponse login(LoginDTO loginDTO);
}
