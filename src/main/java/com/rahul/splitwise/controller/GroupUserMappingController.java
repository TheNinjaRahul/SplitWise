package com.rahul.splitwise.controller;

import com.rahul.splitwise.exception.GroupNotFound;
import com.rahul.splitwise.exception.UserNotFound;
import com.rahul.splitwise.model.GroupUserMapping;
import com.rahul.splitwise.service.IGroupUserMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("UserGroupMapping")
public class GroupUserMappingController {

    @Autowired
    IGroupUserMappingService groupUserMappingService;

    @RequestMapping(value = "/addGroupUserMapping", method = RequestMethod.POST)
    public GroupUserMapping addGroupUserMapping(@RequestBody GroupUserMapping GroupUserMapping) throws UserNotFound, GroupNotFound {
        return groupUserMappingService.addGroupUserMapping(GroupUserMapping);
    }

    @RequestMapping(value = "/updateGroupUserMapping", method = RequestMethod.PUT)
    public GroupUserMapping editGroupUserMapping(@RequestBody GroupUserMapping GroupUserMapping) {
        return groupUserMappingService.editGroupUserMapping(GroupUserMapping);
    }

    @RequestMapping(value = "/deleteGroupUserMapping", method = RequestMethod.DELETE)
    public GroupUserMapping deleteGroupUserMapping(@RequestBody GroupUserMapping GroupUserMapping) {
        return groupUserMappingService.deleteGroupUserMapping(GroupUserMapping);
    }

    @RequestMapping(value = "/getAllGroupUserMapping", method = RequestMethod.GET)
    public List<GroupUserMapping> getAllGroupUserMapping(@RequestParam int userId) {
        return groupUserMappingService.getAllGroupUserMapping(userId);
    }
}
