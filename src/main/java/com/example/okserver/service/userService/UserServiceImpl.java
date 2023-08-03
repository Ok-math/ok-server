package com.example.okserver.service.userService;

import com.example.okserver.domain.User;
import com.example.okserver.packet.responsebody.LoginResponseBody;
import com.example.okserver.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    //회원가입
    @Override
    public LoginResponseBody createUser(User user) {
        LoginResponseBody loginResponseBody = new LoginResponseBody();

        if(!userRepository.findById(user.getId()).isPresent()) {
            userRepository.save(user);

            loginResponseBody.setId(user.getId());
            loginResponseBody.setName(user.getName());
            loginResponseBody.setPassword(user.getPassword());
            loginResponseBody.setResult(true);
        }
        else{
            loginResponseBody.setResult(false);
        }


        return loginResponseBody;
    }



    //로그인
    @Override
    public LoginResponseBody existUser(String id, String password) {
        LoginResponseBody responseBody = new LoginResponseBody();
        User user;
        if(userRepository.findByIdAndPassword(id, password).isPresent()) {
            user = userRepository.findById(id).get();
            responseBody.setResult(true);
            responseBody.setName(user.getName());
            responseBody.setId(user.getId());
        }
        else
            responseBody.setResult(false);

        return responseBody;
    }

}
