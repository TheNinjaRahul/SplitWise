package com.rahul.splitwise.controller;

import com.rahul.splitwise.exception.GroupNotFound;
import com.rahul.splitwise.exception.UserNotFound;
import com.rahul.splitwise.model.GroupUserMapping;
import com.rahul.splitwise.service.IGroupUserMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Group user mapping controller.
 */
@RestController("UserGroupMapping")
public class GroupUserMappingController {

    /**
     * The Group user mapping service.
     */
    @Autowired
    IGroupUserMappingService groupUserMappingService;

    /**
     * Add group user mapping group user mapping.
     *
     * @param GroupUserMapping the group user mapping
     * @return the group user mapping
     * @throws UserNotFound  the user not found
     * @throws GroupNotFound the group not found
     */
    @RequestMapping(value = "/addGroupUserMapping", method = RequestMethod.POST)
    public GroupUserMapping addGroupUserMapping(@RequestBody GroupUserMapping GroupUserMapping) throws UserNotFound, GroupNotFound {
        return groupUserMappingService.addGroupUserMapping(GroupUserMapping);
    }

    /**
     * Edit group user mapping group user mapping.
     *
     * @param GroupUserMapping the group user mapping
     * @return the group user mapping
     */
    @RequestMapping(value = "/updateGroupUserMapping", method = RequestMethod.PUT)
    public GroupUserMapping editGroupUserMapping(@RequestBody GroupUserMapping GroupUserMapping) {
        return groupUserMappingService.editGroupUserMapping(GroupUserMapping);
    }

    /**
     * Delete group user mapping group user mapping.
     *
     * @param GroupUserMapping the group user mapping
     * @return the group user mapping
     */
    @RequestMapping(value = "/deleteGroupUserMapping", method = RequestMethod.DELETE)
    public GroupUserMapping deleteGroupUserMapping(@RequestBody GroupUserMapping GroupUserMapping) {
        return groupUserMappingService.deleteGroupUserMapping(GroupUserMapping);
    }

    /**
     * Gets all group user mapping.
     *
     * @param userId the user id
     * @return the all group user mapping
     */
    @RequestMapping(value = "/getAllGroupUserMapping", method = RequestMethod.GET)
    public List<GroupUserMapping> getAllGroupUserMapping(@RequestParam int userId) {
        return groupUserMappingService.getAllGroupUserMapping(userId);
    }
}
