package com.UserService.UserService.Controller;

import com.UserService.UserService.Entity.User;
import com.UserService.UserService.Service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.createUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<User>> getUser(){
        List<User> allUse = userService.getAllUse();
        return new ResponseEntity<>(allUse,HttpStatus.OK);
    }
    @GetMapping("{userId}")
    public ResponseEntity<User> getById(@PathVariable("userId")String userId){
        User userById = userService.getUserById(userId);
        return new ResponseEntity<>(userById,HttpStatus.OK);
    }
}
