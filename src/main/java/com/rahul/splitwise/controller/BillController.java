package com.rahul.splitwise.controller;


import com.rahul.splitwise.model.Bill;
import com.rahul.splitwise.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("bill")
public class BillController {

    @Autowired
    IBillService billService;

    @RequestMapping(value = "/addBill", method = RequestMethod.POST)
    public Bill addBill(@RequestBody Bill Bill) {
        return billService.addBill(Bill);
    }


    @RequestMapping(value = "/updateBill", method = RequestMethod.PUT)
    public Bill editBill(@RequestBody Bill Bill) {
        return billService.editBill(Bill);
    }

    @RequestMapping(value = "/deleteBill", method = RequestMethod.DELETE)
    public Bill deleteBill(@RequestBody Bill Bill) {
        return billService.deleteBill(Bill);
    }

    @RequestMapping(value = "/getAllBill", method = RequestMethod.GET)
    public List<Bill> getAllBill(@RequestParam int userId) {
        return billService.getAllBill(userId);
    }
}
