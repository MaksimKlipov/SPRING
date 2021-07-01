package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.dao.UserDao;
import web.model.User;
import web.model.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RoleDao roleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    //берём роль из БД
    //присваиваем её новому пользователю и сохраняем в БД
    @Override
    public void saveUser(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getRole(1L));
        user.setRoles(roles);
        userDao.saveUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void updateUser(Long id, User user) {
        User userToBeUpdate = userDao.getUser(id);

        userToBeUpdate.setUsername(user.getUsername());
        userToBeUpdate.setPassword(user.getPassword());
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
