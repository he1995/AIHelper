package com.example.aihelper.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findBUserByUsername(String username);
}
