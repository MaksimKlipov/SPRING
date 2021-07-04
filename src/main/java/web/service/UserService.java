package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);
    User findByUsername(String username);
    void saveUser(User user);
    List<User> getAllUsers();
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
