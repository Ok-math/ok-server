package com.example.okserver.service.userService;

import com.example.okserver.domain.User;
import com.example.okserver.packet.responsebody.LoginResponseBody;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    LoginResponseBody createUser(User user);
    LoginResponseBody existUser(String id, String password);
}
