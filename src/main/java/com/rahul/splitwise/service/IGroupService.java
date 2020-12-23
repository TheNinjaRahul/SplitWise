package com.rahul.splitwise.service;

import com.rahul.splitwise.model.Group;

import java.util.List;

/**
 * The interface Group service.
 */
public interface IGroupService {
    /**
     * Add group group.
     *
     * @param group the group
     * @return the group
     */
    public Group addGroup(Group group);

    /**
     * Edit group group.
     *
     * @param group the group
     * @return the group
     */
    public Group editGroup(Group group);

    /**
     * Delete group group.
     *
     * @param group the group
     * @return the group
     */
    public Group deleteGroup(Group group);

    /**
     * Gets all group.
     *
     * @param userId the user id
     * @return the all group
     */
    public List<Group> getAllGroup(int userId);
}

