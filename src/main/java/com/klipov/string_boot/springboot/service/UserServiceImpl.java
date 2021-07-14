package com.klipov.string_boot.springboot.service;

import com.klipov.string_boot.springboot.repository.RoleRepository;
import com.klipov.string_boot.springboot.repository.UserRepository;
import com.klipov.string_boot.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow();
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
        Optional<User> userToBeUpdate = userRepository.findById(id);
        User user1 = userToBeUpdate.orElseThrow();

        user1.setUsername(user.getUsername());
        user1.setLastname(user.getLastname());
        user1.setAge(user.getAge());
        user1.setEmail(user.getEmail());
        user1.setRoles(user.getRole());
        if (!user1.getPassword().equals(user.getPassword())) {
            user1.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        userRepository.save(user1);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
