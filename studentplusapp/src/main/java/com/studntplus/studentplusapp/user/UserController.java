package com.studntplus.studentplusapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String username, @RequestParam String password, @RequestParam Integer role) {
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setRole(role);
        userRepository.save(u);
        return "Usuario registrado con éxito";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
