package com.ecommerce.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.demo.entity.User;
import com.ecommerce.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User found = userRepository.findByUsername(username);
        if (found != null && found.getPassword().equals(password)) {
            return found;
        }
        return null;
    }

    public boolean existsByUsername(String username) {
        throw new UnsupportedOperationException("Unimplemented method 'existsByUsername'");
    }
}
