package com.example.okserver.controller;


import com.example.okserver.domain.User;
import com.example.okserver.packet.requestbody.LoginRequestBody;
import com.example.okserver.packet.responsebody.LoginResponseBody;
import com.example.okserver.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @Autowired  //
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signup")
    public LoginResponseBody signup(@RequestBody LoginRequestBody requestBody){
        User user = new User();
        user.setId(requestBody.getId());
        user.setPassword(requestBody.getPassword());
        user.setName(requestBody.getName());
        return userService.createUser(user);
    }
    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequestBody requestBody){
        return userService.existUser(requestBody.getId());
    }
}
