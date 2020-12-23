package com.rahul.splitwise.service;

import com.rahul.splitwise.exception.GivenDataIsNotInProperFormat;
import com.rahul.splitwise.exception.GroupNotFound;
import com.rahul.splitwise.exception.UserNotFound;
import com.rahul.splitwise.model.SplitBill;

import java.util.List;

/**
 * The interface Split bill service.
 */
public interface ISplitBillService {
    /**
     * Split bill with group boolean.
     *
     * @param amount  the amount
     * @param groupId the group id
     * @param userId  the user id
     * @param billId  the bill id
     * @return the boolean
     * @throws GroupNotFound the group not found
     * @throws UserNotFound  the user not found
     */
    public boolean splitBillWithGroup(double amount, int groupId, int userId, int billId) throws GroupNotFound, UserNotFound;

    /**
     * Split bill percentage wise boolean.
     *
     * @param amount the amount
     * @param userId the user id
     * @param billId the bill id
     * @param a      the a
     * @return the boolean
     * @throws GivenDataIsNotInProperFormat the given data is not in proper format
     * @throws UserNotFound                 the user not found
     */
    boolean splitBillPercentageWise(double amount, int userId, int billId, int[] a) throws GivenDataIsNotInProperFormat, UserNotFound;

    /**
     * Gets all owe details of user.
     *
     * @param userId the user id
     * @return the all owe details of user
     */
    List<SplitBill> getAllOweDetailsOfUser(int userId);
}
