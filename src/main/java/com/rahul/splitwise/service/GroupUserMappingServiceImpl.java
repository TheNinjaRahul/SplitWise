package com.rahul.splitwise.service;

import com.rahul.splitwise.exception.GroupNotFound;
import com.rahul.splitwise.exception.UserNotFound;
import com.rahul.splitwise.model.GroupUserMapping;
import com.rahul.splitwise.repository.GroupDao;
import com.rahul.splitwise.repository.GroupUserMappingDao;
import com.rahul.splitwise.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Group user mapping service.
 */
@Service
public class GroupUserMappingServiceImpl implements IGroupUserMappingService {

    /**
     * The Group user mapping dao.
     */
    @Autowired
    GroupUserMappingDao groupUserMappingDao;

    /**
     * The User dao.
     */
    @Autowired
    UserDao userDao;

    /**
     * The Group dao.
     */
    @Autowired
    GroupDao groupDao;

    @Override
    public GroupUserMapping addGroupUserMapping(GroupUserMapping groupUserMapping) throws UserNotFound, GroupNotFound {
        int userId1 = groupUserMapping.getUserId();
        int groupId = groupUserMapping.getGroupId();
        if (!userDao.existsById(userId1)) {
            throw new UserNotFound("User ID not Found");
        }

        if (!groupDao.existsById(groupId)) {
            throw new GroupNotFound("Group ID not Found");
        }
        return groupUserMappingDao.save(groupUserMapping);
    }

    @Override
    public GroupUserMapping editGroupUserMapping(GroupUserMapping groupUserMapping) {
        return groupUserMappingDao.save(groupUserMapping);
    }

    @Override
    public GroupUserMapping deleteGroupUserMapping(GroupUserMapping groupUserMapping) {
        groupUserMappingDao.delete(groupUserMapping);
        return groupUserMapping;
    }

    @Override
    public List<GroupUserMapping> getAllGroupUserMapping(int userId) {
        return groupUserMappingDao.findByUserId(userId);
    }

    @Override
    public List<GroupUserMapping> findByGroupID(int groupId) {
        return groupUserMappingDao.findByGroupId(groupId);
    }

}
