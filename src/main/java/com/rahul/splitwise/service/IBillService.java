package com.rahul.splitwise.service;

import com.rahul.splitwise.model.Bill;

import java.util.List;

public interface IBillService {
    public Bill addBill(Bill Bill);

    public Bill editBill(Bill Bill);

    public Bill deleteBill(Bill Bill);

    public List<Bill> getAllBill(int userId);
}
