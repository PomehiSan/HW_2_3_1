package myapp.dao;

import myapp.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    User getUser(long id);

    List<User> getUsers();

    void updateUser(User user);

    void deleteUser(long id);
}
