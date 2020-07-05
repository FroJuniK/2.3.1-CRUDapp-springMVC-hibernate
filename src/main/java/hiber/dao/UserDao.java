package hiber.dao;

import hiber.model.User;
import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User getUserById(long id);

    void addUser(User user);

    void deleteUser(long id);

    void editUser(User user);
}
