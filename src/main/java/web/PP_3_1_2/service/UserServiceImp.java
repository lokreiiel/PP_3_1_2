package web.PP_3_1_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.PP_3_1_2.dao.UserDao;
import web.PP_3_1_2.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDao userDao;
    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User showUserById(int id) {
        return userDao.showUserById(id);
    }
}