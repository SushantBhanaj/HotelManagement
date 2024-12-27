package com.UserService.UserService.Service;

import com.UserService.UserService.Entity.User;
import com.UserService.UserService.Exception.ResourceNotFoundException;
import com.UserService.UserService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepo;
    @Override
    public User createUser(User user) {
        User save = userRepo.save(user);
        String userUniq = UUID.randomUUID().toString();
        user.getUserId(userUniq);
        return save;
    }

    @Override
    public List<User> getAllUse() {
        List<User> all = userRepo.findAll();
        return all;
    }

    @Override
    public User getUserById(String userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user id not found:" + userId));
        return user;
    }
}
