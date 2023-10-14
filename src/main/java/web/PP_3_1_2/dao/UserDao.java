package web.PP_3_1_2.dao;

import web.PP_3_1_2.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> allUsers();

    User update(User user);
    void deleteUser(int id);
    User showUserById(int id);
}