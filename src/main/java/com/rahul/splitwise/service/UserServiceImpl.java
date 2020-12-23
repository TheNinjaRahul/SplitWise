package com.rahul.splitwise.service;

import com.rahul.splitwise.model.User;
import com.rahul.splitwise.model.UserWithGiveOrTake;
import com.rahul.splitwise.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDao userDao;

    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User editUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User deleteUser(User user) {
        userDao.delete(user);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }


    @Override
    public List<UserWithGiveOrTake> getAllDataUserNeedToTake(int userId) {
        return userDao.getAllDataThatUserNeedToTake(userId);
    }

    @Override
    public List<UserWithGiveOrTake> getAllDataUserNeedToGive(int userId) {
        return userDao.getAllDataThatUserNeedToGive(userId);
    }
}
