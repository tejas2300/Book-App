package com.stackroute.capstone.services;

import com.stackroute.capstone.model.User;
import com.stackroute.capstone.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;
    public User saveUser(User user)
    {
        User result =registrationRepository.save(user);
        return result;
    }
    public User fetchUserByEmailId(String email)
    {
       return registrationRepository.findByEmail(email);
    }
    public User fetchUserByEmailAndPassword(String email, String password)
    {
        return registrationRepository.findByEmailAndPassword(email,password);
    }
}
