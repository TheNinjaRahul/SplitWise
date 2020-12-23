package com.rahul.splitwise.service;

import com.rahul.splitwise.model.Bill;
import com.rahul.splitwise.repository.BillDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements IBillService {

    @Autowired
    BillDao billDao;


    @Override
    public Bill addBill(Bill Bill) {
        return billDao.save(Bill);
    }

    @Override
    public Bill editBill(Bill Bill) {
        return billDao.save(Bill);
    }

    @Override
    public Bill deleteBill(Bill Bill) {
        billDao.delete(Bill);
        return null;
    }

    @Override
    public List<Bill> getAllBill(int userId) {
        return billDao.findByUserId(userId);
    }
}
