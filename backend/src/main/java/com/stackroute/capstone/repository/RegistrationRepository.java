package com.stackroute.capstone.repository;

import com.stackroute.capstone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User,Integer> {

    public User findByEmail(String email);

    public User findByEmailAndPassword(String email, String password);
}
