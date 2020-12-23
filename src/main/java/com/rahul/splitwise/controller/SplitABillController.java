package com.rahul.splitwise.controller;

import com.rahul.splitwise.exception.GivenDataIsNotInProperFormat;
import com.rahul.splitwise.exception.GroupNotFound;
import com.rahul.splitwise.exception.UserNotFound;
import com.rahul.splitwise.service.ISplitBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("splitBill")
public class SplitABillController {


    @Autowired
    ISplitBillService iSplitBillService;

    @RequestMapping(value = "/percentageWise", method = RequestMethod.POST)
    public boolean percentageWise(double amount, int userId, int billId, int[] a) {
        try {
            return iSplitBillService.splitBillPercentageWise(amount, userId, billId, a);
        } catch (GivenDataIsNotInProperFormat givenDataIsNotInProperFormat) {
            givenDataIsNotInProperFormat.printStackTrace();
        } catch (UserNotFound userNotFound) {
            userNotFound.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/splitInGroup", method = RequestMethod.POST)
    public boolean splitInGroup(double amount, int groupId, int userId, int billId) {
        try {
            return iSplitBillService.splitBillWithGroup(amount, groupId, userId, billId);
        } catch (GroupNotFound groupNotFound) {
            groupNotFound.printStackTrace();
        } catch (UserNotFound userNotFound) {
            userNotFound.printStackTrace();
        }
        return false;
    }
}
