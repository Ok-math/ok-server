package com.example.okserver.controller;


import com.example.okserver.domain.User;
import com.example.okserver.packet.requestbody.LoginRequestBody;
import com.example.okserver.packet.responcebody.LoginResponseBody;
import com.example.okserver.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @Autowired  //
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public LoginResponseBody login(@RequestBody LoginRequestBody requestBody){
        User user = new User();
        user.setId(requestBody.getId());
        user.setPassword(requestBody.getPassword());
        return userService.createUser(user);
    }
}
