package com.rahul.splitwise.service;

import com.rahul.splitwise.exception.GivenDataIsNotInProperFormat;
import com.rahul.splitwise.exception.GroupNotFound;
import com.rahul.splitwise.exception.UserNotFound;
import com.rahul.splitwise.model.SplitBill;

import java.util.List;

public interface ISplitBillService {
    public boolean splitBillWithGroup(double amount, int groupId, int userId, int billId) throws GroupNotFound, UserNotFound;

    boolean splitBillPercentageWise(double amount, int userId, int billId, int[] a) throws GivenDataIsNotInProperFormat, UserNotFound;

    List<SplitBill> getAllOweDetailsOfUser(int userId);
}
