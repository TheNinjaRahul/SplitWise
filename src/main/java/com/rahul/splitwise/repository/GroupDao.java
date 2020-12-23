package com.rahul.splitwise.repository;

import com.rahul.splitwise.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupDao extends JpaRepository<Group, Integer> {
    /**
     * // Save
     * // findById
     * are default one
     */

    public List<Group> findByUserId(int id);
}
