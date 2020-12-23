package com.rahul.splitwise.repository;

import com.rahul.splitwise.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Bill dao.
 */
public interface BillDao extends JpaRepository<Bill, Integer> {
    /**
     * Find by user id list.
     *
     * @param id the id
     * @return the list
     */
    public List<Bill> findByUserId(int id);
}
