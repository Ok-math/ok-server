package com.example.okserver.service.UserService;

import com.example.okserver.domain.User;
import com.example.okserver.packet.responsebody.LoginResponseBody;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    LoginResponseBody createUser(User user);
    boolean existUser(String id);
}
