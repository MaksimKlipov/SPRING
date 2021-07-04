package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public User getUser(Long id);
    User findByUsername(String username);
    public void saveUser(User user);
    public List<User> getAllUsers();
    public void updateUser(Long id, User user);
    public void deleteUser(Long id);
}
