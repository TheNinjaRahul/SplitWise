package com.rahul.splitwise.service;

import com.rahul.splitwise.model.User;
import com.rahul.splitwise.model.UserWithGiveOrTake;

import java.util.List;

/**
 * The interface User service.
 */
public interface IUserService {
    /**
     * Add user user.
     *
     * @param user the user
     * @return the user
     */
    public User addUser(User user);

    /**
     * Edit user user.
     *
     * @param user the user
     * @return the user
     */
    public User editUser(User user);

    /**
     * Delete user user.
     *
     * @param user the user
     * @return the user
     */
    public User deleteUser(User user);

    /**
     * Gets all user.
     *
     * @return the all user
     */
    public List<User> getAllUser();

    /**
     * Gets all data user need to take.
     *
     * @param userId the user id
     * @return the all data user need to take
     */
    public List<UserWithGiveOrTake> getAllDataUserNeedToTake(int userId);

    /**
     * Gets all data user need to give.
     *
     * @param userId the user id
     * @return the all data user need to give
     */
    List<UserWithGiveOrTake> getAllDataUserNeedToGive(int userId);
}
