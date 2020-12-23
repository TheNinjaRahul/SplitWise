package com.rahul.splitwise.service;

import com.rahul.splitwise.model.User;
import com.rahul.splitwise.model.UserWithGiveOrTake;

import java.util.List;

public interface IUserService {
    public User addUser(User user);

    public User editUser(User user);

    public User deleteUser(User user);

    public List<User> getAllUser();

    public List<UserWithGiveOrTake> getAllDataUserNeedToTake(int userId);

    List<UserWithGiveOrTake> getAllDataUserNeedToGive(int userId);
}
