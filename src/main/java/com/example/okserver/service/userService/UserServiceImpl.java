package com.example.okserver.service.userService;

import com.example.okserver.domain.User;
import com.example.okserver.packet.responsebody.LoginResponseBody;
import com.example.okserver.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


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


    @Override
    public boolean existUser(String id) {
        if(!userRepository.findById(id).isPresent())
            return true;
        else
            return false;
    }


}
