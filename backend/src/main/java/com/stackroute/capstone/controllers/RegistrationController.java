package com.stackroute.capstone.controllers;

import com.stackroute.capstone.model.User;
import com.stackroute.capstone.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
    @Autowired
    private RegistrationService service;

    @PostMapping("/register")
    // @RequestMapping("/")

    // registration request
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmail();
        if (tempEmailId != null && !"".equals(tempEmailId)) {
            User userobj = service.fetchUserByEmailId(tempEmailId);
            if (userobj != null) {
                throw new Exception("User with" + tempEmailId + " already exists");
            }
        }

        User userObj = service.saveUser(user);
        return userObj;
    }

    // login request
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmail();
        String tempPassword = user.getPassword();
        User userObj = null;
        if (tempEmailId != null && tempPassword != null) {
            userObj = service.fetchUserByEmailAndPassword(tempEmailId, tempPassword);
        }
        if (userObj == null) {
            throw new Exception("User does not exists");
        }
        return userObj;
    }

}
