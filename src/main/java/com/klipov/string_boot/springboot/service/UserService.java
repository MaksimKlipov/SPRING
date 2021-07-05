package com.klipov.string_boot.springboot.service;



import com.klipov.string_boot.springboot.model.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);
    User findByUsername(String username);
    void saveUser(User user);
    List<User> getAllUsers();
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
