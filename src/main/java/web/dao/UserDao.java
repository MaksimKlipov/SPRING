package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    User getUser(Long id);
    void saveUser(User user);
    List<User> getAllUsers();
    void deleteUser(Long id);
}
