package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> show() {
        return userDao.show();
    }

    @Override
    public User index(int id) {
        return userDao.index(id);
    }

    @Override
    public void remove(int id) {
        userDao.remove(id);
    }

    @Override
    public void update(User updatedUser) {
        userDao.update(updatedUser);
    }

}
