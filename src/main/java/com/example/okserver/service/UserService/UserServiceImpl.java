package com.example.okserver.service.UserService;

import com.example.okserver.domain.User;
import com.example.okserver.packet.responsebody.LoginResponseBody;
import com.example.okserver.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    //없어도댐
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private LoginResponseBody loginResponseBody = new LoginResponseBody();


    @Override
    public LoginResponseBody createUser(User user) {
        if(!userRepository.findById(user.getId()).isPresent()) {
            userRepository.save(user);
            loginResponseBody.setId(user.getId());
            loginResponseBody.setName("kwon");
            loginResponseBody.setPassword(user.getPassword());
            loginResponseBody.setResult(true);
        }
        else{
            loginResponseBody.setId(user.getId());
            loginResponseBody.setName("kwon");
            loginResponseBody.setPassword(user.getPassword());
            loginResponseBody.setResult(false);
        }

        return loginResponseBody;
    }

    @Override
    public boolean existUser(String id) {
        if(userRepository.findById(id).isPresent())
            return true;
        else
            return false;
    }


}
