package com.studntplus.studentplusapp.service;

import com.studntplus.studentplusapp.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> fetchUserList();

    User updateUser(User user, String username);

    void deleteUserbyUsername(String username);
}
