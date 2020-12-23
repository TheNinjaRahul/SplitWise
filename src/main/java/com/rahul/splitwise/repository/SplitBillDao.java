package com.rahul.splitwise.repository;

import com.rahul.splitwise.model.SplitBill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SplitBillDao extends JpaRepository<SplitBill, Integer> {
    public List<SplitBill> findByUserId(int userId);

    public int deleteByBillId(int billId);
}
