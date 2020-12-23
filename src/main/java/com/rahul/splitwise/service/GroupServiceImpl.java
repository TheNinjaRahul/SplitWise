package com.rahul.splitwise.service;

import com.rahul.splitwise.model.Group;
import com.rahul.splitwise.repository.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements IGroupService {

    @Autowired
    GroupDao groupDao;

    @Override
    public Group addGroup(Group group) {
        return groupDao.save(group);
    }

    @Override
    public Group editGroup(Group group) {
        return groupDao.save(group);
    }

    @Override
    public Group deleteGroup(Group group) {
        groupDao.delete(group);
        return null;
    }

    @Override
    public List<Group> getAllGroup(int userId) {
        return groupDao.findByUserId(userId);
    }
}
