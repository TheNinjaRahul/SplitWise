package com.rahul.splitwise.controller;

import com.rahul.splitwise.model.Group;
import com.rahul.splitwise.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Group controller.
 */
@RestController("group")
public class GroupController {

    /**
     * The Group service.
     */
    @Autowired
    IGroupService iGroupService;

    /**
     * Add group group.
     *
     * @param group the group
     * @return the group
     */
    @RequestMapping(value = "/addGroup", method = RequestMethod.POST)
    public Group addGroup(@RequestBody Group group) {
        return iGroupService.addGroup(group);
    }


    /**
     * Edit group group.
     *
     * @param group the group
     * @return the group
     */
    @RequestMapping(value = "/updateGroup", method = RequestMethod.PUT)
    public Group editGroup(@RequestBody Group group) {
        return iGroupService.editGroup(group);
    }

    /**
     * Delete group group.
     *
     * @param group the group
     * @return the group
     */
    @RequestMapping(value = "/deleteGroup", method = RequestMethod.DELETE)
    public Group deleteGroup(@RequestBody Group group) {
        return iGroupService.deleteGroup(group);
    }

    /**
     * Gets all group.
     *
     * @param userId the user id
     * @return the all group
     */
    @RequestMapping(value = "/getAllGroup", method = RequestMethod.GET)
    public List<Group> getAllGroup(@RequestParam int userId) {
        return iGroupService.getAllGroup(userId);
    }

}
