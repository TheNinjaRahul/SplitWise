package com.rahul.splitwise.service;

import com.rahul.splitwise.exception.GivenDataIsNotInProperFormat;
import com.rahul.splitwise.exception.GroupNotFound;
import com.rahul.splitwise.exception.UserNotFound;
import com.rahul.splitwise.model.*;
import com.rahul.splitwise.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * The type Split bill service.
 */
@Service
public class SplitBillServiceImpl implements ISplitBillService {

    /**
     * The Group dao.
     */
    @Autowired
    GroupDao groupDao;

    /**
     * The Group user mapping dao.
     */
    @Autowired
    GroupUserMappingDao groupUserMappingDao;

    /**
     * The User dao.
     */
    @Autowired
    UserDao userDao;

    /**
     * The Bill dao.
     */
    @Autowired
    BillDao billDao;

    /**
     * The Split bill dao.
     */
    @Autowired
    SplitBillDao splitBillDao;

    @Override
    @Transactional
    public boolean splitBillWithGroup(double amount, int groupId, int userId, int billId) throws GroupNotFound, UserNotFound {
        Optional<Group> group = groupDao.findById(groupId);
        if (!group.isPresent()) {
            throw new GroupNotFound("Group Not Found");
        }

        Optional<User> user = userDao.findById(userId);
        if (!user.isPresent()) {
            throw new UserNotFound("User Not Found");
        }

        Optional<Bill> bill = billDao.findById(billId);
        if (!bill.isPresent()) {
            throw new UserNotFound("Bill Not Found");
        }

        splitBillDao.deleteByBillId(billId);
        List<GroupUserMapping> groupUserMappings = groupUserMappingDao.findByGroupId(groupId);
        double perUserAmount = amount / groupUserMappings.size();
        List<SplitBill> list = new LinkedList<>();
        for (GroupUserMapping groupUserMapping : groupUserMappings) {
            //if same user then dont include in list
            if (groupUserMapping.getUserId() == userId) continue;
            SplitBill splitBill = new SplitBill();
            splitBill.setAmount(perUserAmount);
            splitBill.setPaid(false);
            splitBill.setUserId(userId);
            splitBill.setDueUserId(groupUserMapping.getUserId());
            splitBill.setBillId(billId);
            list.add(splitBill);
        }
        splitBillDao.saveAll(list);

        return true;
    }

    @Override
    @Transactional
    public boolean splitBillPercentageWise(double amount, int userId, int billId, int[] a) throws GivenDataIsNotInProperFormat, UserNotFound {
        if (!userDao.existsById(userId)) {
            throw new UserNotFound("User Not Found");
        }

        if (a.length % 2 != 0) {
            throw new GivenDataIsNotInProperFormat("GivenDataIsNotInProperFormat: It should be like Odd index as userId and Even index At % value");
        }

        int count = 0;
        for (int i = 1; i < a.length; i = i + 2) {
            count += a[i];
        }
        if (count != 100) {
            throw new GivenDataIsNotInProperFormat("GivenDataIsNotInProperFormat: 100% bill not spited");
        }

        splitBillDao.deleteByBillId(billId);
        List<SplitBill> list = new LinkedList<>();
        for (int i = 1; i < a.length; i = i + 2) {

            if (a[i - 1] == userId) continue;
            if (!userDao.existsById(a[i - 1])) {
                throw new UserNotFound("User Not Found");
            }

            double val = (amount * a[i]) / 100;
            SplitBill splitBill = new SplitBill();
            splitBill.setAmount(val);
            splitBill.setPaid(false);
            splitBill.setUserId(userId);
            splitBill.setDueUserId(a[i - 1]);
            splitBill.setBillId(billId);
            list.add(splitBill);
        }
        splitBillDao.saveAll(list);
        return true;
    }

    @Override
    public List<SplitBill> getAllOweDetailsOfUser(int userId) {
        return splitBillDao.findByUserId(userId);
    }
}
