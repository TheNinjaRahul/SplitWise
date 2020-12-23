package com.rahul.splitwise.controller;


import com.rahul.splitwise.model.Bill;
import com.rahul.splitwise.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * The type Bill controller.
 */
@RestController("bill")
public class BillController {

    /**
     * The Bill service.
     */
    @Autowired
    IBillService billService;

    /**
     * Add bill bill.
     *
     * @param Bill the bill
     * @return the bill
     */
    @RequestMapping(value = "/addBill", method = RequestMethod.POST)
    public Bill addBill(@RequestBody Bill Bill) {
        return billService.addBill(Bill);
    }


    /**
     * Edit bill bill.
     *
     * @param Bill the bill
     * @return the bill
     */
    @RequestMapping(value = "/updateBill", method = RequestMethod.PUT)
    public Bill editBill(@RequestBody Bill Bill) {
        return billService.editBill(Bill);
    }

    /**
     * Delete bill bill.
     *
     * @param Bill the bill
     * @return the bill
     */
    @RequestMapping(value = "/deleteBill", method = RequestMethod.DELETE)
    public Bill deleteBill(@RequestBody Bill Bill) {
        return billService.deleteBill(Bill);
    }

    /**
     * Gets all bill.
     *
     * @param userId the user id
     * @return the all bill
     */
    @RequestMapping(value = "/getAllBill", method = RequestMethod.GET)
    public List<Bill> getAllBill(@RequestParam int userId) {
        return billService.getAllBill(userId);
    }
}
