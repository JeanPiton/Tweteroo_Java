package com.tweteroojava.api.services;

import org.springframework.stereotype.Service;

import com.tweteroojava.api.dtos.UserDTO;
import com.tweteroojava.api.models.UserModel;
import com.tweteroojava.api.repositories.UserRepository;

@Service
public class UserService {
    
    final UserRepository userRepository;

    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserModel save(UserDTO dto){
        UserModel user = new UserModel(dto);
        return userRepository.save(user);
    }
}
