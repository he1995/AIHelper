package com.example.aihelper.user;

public interface IUserService {

    public User findUserByUsername(String username);

    public Iterable<User> findAllUsers();
}
