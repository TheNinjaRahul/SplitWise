package com.rahul.splitwise.service;

import com.rahul.splitwise.model.Bill;

import java.util.List;

/**
 * This interface is responsible to perform CRUD on BILL
 */
public interface IBillService {
    /**
     * Add bill bill.
     *
     * @param Bill the bill
     * @return bill
     */
    public Bill addBill(Bill Bill);

    /**
     * Edit bill bill.
     *
     * @param Bill the bill
     * @return the bill
     */
    public Bill editBill(Bill Bill);

    /**
     * Delete bill bill.
     *
     * @param Bill the bill
     * @return the bill
     */
    public Bill deleteBill(Bill Bill);

    /**
     * Gets all bill.
     *
     * @param userId the user id
     * @return the all bill
     */
    public List<Bill> getAllBill(int userId);
}
