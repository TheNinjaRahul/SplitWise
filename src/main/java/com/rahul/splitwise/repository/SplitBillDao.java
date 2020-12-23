package com.rahul.splitwise.repository;

import com.rahul.splitwise.model.SplitBill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Split bill dao.
 */
public interface SplitBillDao extends JpaRepository<SplitBill, Integer> {
    /**
     * Find by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    public List<SplitBill> findByUserId(int userId);

    /**
     * Delete by bill id int.
     *
     * @param billId the bill id
     * @return the int
     */
    public int deleteByBillId(int billId);
}
