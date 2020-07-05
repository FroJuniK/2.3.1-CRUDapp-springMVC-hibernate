package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao dao;

    @Transactional
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Transactional
    public User getUserById(long id) {
        return dao.getUserById(id);
    }

    @Transactional
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Transactional
    public void deleteUser(long id) {
        dao.deleteUser(id);
    }

    @Transactional
    public void editUser(User user) {
        dao.editUser(user);
    }
}
