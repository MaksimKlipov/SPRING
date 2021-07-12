package com.klipov.string_boot.springboot.service;

import com.klipov.string_boot.springboot.repository.RoleRepository;
import com.klipov.string_boot.springboot.repository.UserRepository;
import com.klipov.string_boot.springboot.model.Role;
import com.klipov.string_boot.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUser(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(Long id, User user) {
        User userToBeUpdate = userRepository.getById(id);

        userToBeUpdate.setUsername(user.getUsername());
        if (!userToBeUpdate.getPassword().equals(user.getPassword())) {
            userToBeUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.save(userToBeUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
