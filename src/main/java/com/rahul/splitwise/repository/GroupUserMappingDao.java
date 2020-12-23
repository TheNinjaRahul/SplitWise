package com.rahul.splitwise.repository;

import com.rahul.splitwise.model.GroupUserMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Group user mapping dao.
 */
public interface GroupUserMappingDao extends JpaRepository<GroupUserMapping, Integer> {
    /**
     * Find by user id list.
     *
     * @param id the id
     * @return the list
     */
    public List<GroupUserMapping> findByUserId(int id);

    /**
     * Find by group id list.
     *
     * @param id the id
     * @return the list
     */
    public List<GroupUserMapping> findByGroupId(int id);
}
