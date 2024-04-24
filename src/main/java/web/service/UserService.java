package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> show();

    User index(int id);

    void update(User updatedUser);

    void remove(int id);

}