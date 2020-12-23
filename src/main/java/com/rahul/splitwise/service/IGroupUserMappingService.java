package com.rahul.splitwise.service;

import com.rahul.splitwise.exception.GroupNotFound;
import com.rahul.splitwise.exception.UserNotFound;
import com.rahul.splitwise.model.GroupUserMapping;

import java.util.List;

/**
 * The interface Group user mapping service.
 */
public interface IGroupUserMappingService {
    /**
     * Add group user mapping group user mapping.
     *
     * @param groupUserMapping the group user mapping
     * @return the group user mapping
     * @throws UserNotFound  the user not found
     * @throws GroupNotFound the group not found
     */
    public GroupUserMapping addGroupUserMapping(GroupUserMapping groupUserMapping) throws UserNotFound, GroupNotFound;

    /**
     * Edit group user mapping group user mapping.
     *
     * @param groupUserMapping the group user mapping
     * @return the group user mapping
     */
    public GroupUserMapping editGroupUserMapping(GroupUserMapping groupUserMapping);

    /**
     * Delete group user mapping group user mapping.
     *
     * @param groupUserMapping the group user mapping
     * @return the group user mapping
     */
    public GroupUserMapping deleteGroupUserMapping(GroupUserMapping groupUserMapping);

    /**
     * Gets all group user mapping.
     *
     * @param userId the user id
     * @return the all group user mapping
     */
    public List<GroupUserMapping> getAllGroupUserMapping(int userId);

    /**
     * Find by group id list.
     *
     * @param groupId the group id
     * @return the list
     */
    public List<GroupUserMapping> findByGroupID(int groupId);
}
