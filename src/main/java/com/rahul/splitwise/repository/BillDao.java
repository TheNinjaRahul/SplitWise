package com.rahul.splitwise.repository;

import com.rahul.splitwise.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillDao extends JpaRepository<Bill, Integer> {
    public List<Bill> findByUserId(int id);
}
