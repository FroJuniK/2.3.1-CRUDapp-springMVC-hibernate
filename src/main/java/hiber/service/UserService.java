package hiber.service;

import hiber.model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(long id);

    void addUser(User user);

    void deleteUser(long id);

    void editUser(User user);
}
