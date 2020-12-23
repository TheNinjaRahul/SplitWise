package com.rahul.splitwise.controller;

import com.rahul.splitwise.model.Group;
import com.rahul.splitwise.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("group")
public class GroupController {

    @Autowired
    IGroupService iGroupService;

    @RequestMapping(value = "/addGroup", method = RequestMethod.POST)
    public Group addGroup(@RequestBody Group group) {
        return iGroupService.addGroup(group);
    }


    @RequestMapping(value = "/updateGroup", method = RequestMethod.PUT)
    public Group editGroup(@RequestBody Group group) {
        return iGroupService.editGroup(group);
    }

    @RequestMapping(value = "/deleteGroup", method = RequestMethod.DELETE)
    public Group deleteGroup(@RequestBody Group group) {
        return iGroupService.deleteGroup(group);
    }

    @RequestMapping(value = "/getAllGroup", method = RequestMethod.GET)
    public List<Group> getAllGroup(@RequestParam int userId) {
        return iGroupService.getAllGroup(userId);
    }

}
