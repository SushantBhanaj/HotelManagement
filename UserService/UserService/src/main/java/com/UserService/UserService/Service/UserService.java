package com.UserService.UserService.Service;

import com.UserService.UserService.Entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUse();
    User getUserById(String userId);
}
