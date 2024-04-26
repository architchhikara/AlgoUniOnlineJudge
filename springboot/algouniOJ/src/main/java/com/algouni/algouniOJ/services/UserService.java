package com.algouni.algouniOJ.services;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.algouni.algouniOJ.models.User;
import com.algouni.algouniOJ.repositories.UserRepository;

import java.util.Optional;

// TODO after basic testing of Platform without User authentication
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    // public User registerUser(User user) {
    // String hashedPassword = passwordEncoder.encode(user.getPassword());
    // user.setPassword(hashedPassword);
    // return userRepository.save(user);
    // }

    // public Optional<User> findByUsername(String username) {
    // return userRepository.findByUsername(username);
    // }

    // public User validateLogin(String username, String rawPassword) {
    // Optional<User> optionalUser = findByUsername(username);

    // if (optionalUser.isPresent() && passwordEncoder.matches(rawPassword,
    // optionalUser.get().getPassword())) {
    // return optionalUser.get();
    // } else {
    // return null; // Or throw an AuthenticationException if suitable
    // }
    // }

    // public User getUserById(Long userId) {
    // return userRepository.findById(userId).orElse(null);
    // }
}
