package com.rahul.splitwise.service;

import com.rahul.splitwise.exception.GroupNotFound;
import com.rahul.splitwise.exception.UserNotFound;
import com.rahul.splitwise.model.GroupUserMapping;

import java.util.List;

public interface IGroupUserMappingService {
    public GroupUserMapping addGroupUserMapping(GroupUserMapping groupUserMapping) throws UserNotFound, GroupNotFound;

    public GroupUserMapping editGroupUserMapping(GroupUserMapping groupUserMapping);

    public GroupUserMapping deleteGroupUserMapping(GroupUserMapping groupUserMapping);

    public List<GroupUserMapping> getAllGroupUserMapping(int userId);

    public List<GroupUserMapping> findByGroupID(int groupId);
}
