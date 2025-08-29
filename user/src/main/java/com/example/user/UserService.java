package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findBUserByUsername(username);
    }

    @Override
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }
}
