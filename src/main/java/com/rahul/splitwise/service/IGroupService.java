package com.rahul.splitwise.service;

import com.rahul.splitwise.model.Group;

import java.util.List;

public interface IGroupService {
    public Group addGroup(Group group);

    public Group editGroup(Group group);

    public Group deleteGroup(Group group);

    public List<Group> getAllGroup(int userId);
}
