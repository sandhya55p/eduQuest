package com.eduquest.controller;
import com.eduquest.dto.LoginDTO;
import com.eduquest.dto.LoginResponse;
import com.eduquest.dto.UserDTO;
import  com.eduquest.entity.User;
import  com.eduquest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")

public class UserController {

    @Autowired
    private  UserService userService;
    @PostMapping("/register")
    public  User register(@RequestBody UserDTO userDTO){

        return userService.register(userDTO);
    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginDTO loginDTO){
        System.out.println("Login API called");
        return userService.login(loginDTO);
    }
    @GetMapping("/profile")
    public String profile(){
        return "Welcome to EduQuest! You are authenticated .";
    }


}
