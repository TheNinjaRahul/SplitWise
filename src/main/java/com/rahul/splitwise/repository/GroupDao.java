package com.rahul.splitwise.repository;

import com.rahul.splitwise.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Group dao.
 */
public interface GroupDao extends JpaRepository<Group, Integer> {

    /**
     * // Save
     * // findById
     * are default one
     *
     * @param id the id
     * @return the list
     */
    public List<Group> findByUserId(int id);
}
