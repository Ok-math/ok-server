package com.example.okserver;


import com.example.okserver.repository.UserRepository;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {
    private final UserRepository userRepository;

    public Appconfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
