package com.rahul.splitwise.controller;

import com.rahul.splitwise.model.User;
import com.rahul.splitwise.model.UserWithGiveOrTake;
import com.rahul.splitwise.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @RequestMapping(value = "/getAllDataUserNeedToTake", method = RequestMethod.GET)
    public List<UserWithGiveOrTake> getAllDataUserNeedToTake(int userId) {
        return iUserService.getAllDataUserNeedToTake(userId);
    }

    @RequestMapping(value = "/getAllDataUserNeedToGive", method = RequestMethod.GET)
    public List<UserWithGiveOrTake> getAllDataUserNeedToGive(int userId) {
        return iUserService.getAllDataUserNeedToGive(userId);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return iUserService.addUser(user);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public User editUser(@RequestBody User user) {
        return iUserService.editUser(user);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public User deleteUser(@RequestBody User user) {
        return iUserService.deleteUser(user);
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return iUserService.getAllUser();
    }
}
