package com.rahul.splitwise.repository;

import com.rahul.splitwise.model.GroupUserMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupUserMappingDao extends JpaRepository<GroupUserMapping, Integer> {
    public List<GroupUserMapping> findByUserId(int id);

    public List<GroupUserMapping> findByGroupId(int id);
}
