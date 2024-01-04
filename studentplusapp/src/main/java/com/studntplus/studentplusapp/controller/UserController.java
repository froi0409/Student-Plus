package com.studntplus.studentplusapp.controller;

import com.studntplus.studentplusapp.entity.User;
import com.studntplus.studentplusapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/user")
    public List<User> fetchUserList() {
        return userService.fetchUserList();
    }

    @PutMapping("/user/{username}")
    public User updateUser(@RequestBody User user, @PathVariable("username") String username) {
        return userService.updateUser(user, username);
    }

    @DeleteMapping("/user/{username}")
    public String deleteUserByUsername(@PathVariable("username") String username) {
        userService.deleteUserbyUsername(username);
        return "Deleted Successfully";
    }
}
