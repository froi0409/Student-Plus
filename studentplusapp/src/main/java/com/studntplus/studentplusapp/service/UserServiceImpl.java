package com.studntplus.studentplusapp.service;

import com.studntplus.studentplusapp.entity.User;
import com.studntplus.studentplusapp.repository.UserRepository;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user, String username) {
        User userDB = userRepository.findById(username).get();

        if (Objects.nonNull(user.getUsername()) && !user.getUsername().equals("")) {
            userDB.setUsername(user.getUsername());
        }

        if (Objects.nonNull(user.getPassword()) && !user.getPassword().equals("")) {
            userDB.setPassword(user.getPassword());
        }

        if (Objects.nonNull(user.getFirstName()) && !user.getFirstName().equals("")) {
            userDB.setFirstName(user.getFirstName());
        }

        if (Objects.nonNull(user.getLastName()) && !user.getLastName().equals("")) {
            userDB.setLastName(user.getLastName());
        }

        if (Objects.nonNull(user.getRole())) {
            userDB.setRole(user.getRole());
        }

        return userRepository.save(userDB);
    }

    @Override
    public void deleteUserbyUsername(String username) {
        userRepository.deleteById(username);
    }
}
