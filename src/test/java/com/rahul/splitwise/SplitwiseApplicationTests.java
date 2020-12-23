package com.rahul.splitwise;

import com.rahul.splitwise.exception.GivenDataIsNotInProperFormat;
import com.rahul.splitwise.exception.GroupNotFound;
import com.rahul.splitwise.exception.UserNotFound;
import com.rahul.splitwise.model.*;
import com.rahul.splitwise.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class SplitwiseApplicationTests {


    @Autowired
    IUserService iUserService;

    @Autowired
    IGroupUserMappingService iGroupUserMappingService;

    @Autowired
    IBillService billService;

    @Autowired
    IGroupService iGroupService;

    @Autowired
    ISplitBillService iSplitBillService;


    @Test
    void contextLoads() {
    }


    @Test
    public void TestCreateUserGetUSer() {
        User user = new User();
        user.setName("Rahul");
        user.setEmailId("rahul@123.com");
        user.setPassword("123");
        user.setUserName("rahul");
        User u = iUserService.addUser(user);

        List<User> list = iUserService.getAllUser();
        Assert.isTrue(list.size() == 1);
    }

    @Test
    public void TestCreateGroupAndGetGroup() {

        User user = new User();
        user.setName("Rahul");
        user.setEmailId("rahul@123.com");
        user.setPassword("123");
        user.setUserName("rahul");
        iUserService.addUser(user);

        Group group = new Group();
        group.setName("Goa Trip");
        group.setUserId(1);
        iGroupService.addGroup(group);
        Assert.isTrue(iGroupService.getAllGroup(1).size() == 1);
    }

    @Test
    public void TestGroupMapping() {
        User user = new User();
        user.setName("Rahul");
        user.setEmailId("rahul@123.com");
        user.setPassword("123");
        user.setUserName("rahul");
        User user2 = new User();
        user2.setName("ABC");
        user2.setEmailId("ABC@123.com");
        user2.setPassword("123");
        user2.setUserName("ABC");
        User user2Inserted = iUserService.addUser(user2);
        User user1Inserted = iUserService.addUser(user);

        Group group = new Group();
        group.setName("Goa Trip");
        group.setUserId(1);
        Group inserted = iGroupService.addGroup(group);


        GroupUserMapping groupUserMapping = new GroupUserMapping();
        groupUserMapping.setGroupId(inserted.getId());
        groupUserMapping.setUserId(user1Inserted.getId());
        iGroupUserMappingService.addGroupUserMapping(groupUserMapping);
        GroupUserMapping groupUserMapping2 = new GroupUserMapping();
        groupUserMapping2.setGroupId(inserted.getId());
        groupUserMapping2.setUserId(user2Inserted.getId());
        iGroupUserMappingService.addGroupUserMapping(groupUserMapping2);

        Assert.isTrue(iGroupUserMappingService.findByGroupID(inserted.getId()).size() == 2);
    }

    @Test
    public void testGroupSplit() {
        User user = new User();
        user.setName("Rahul");
        user.setEmailId("rahul@123.com");
        user.setPassword("123");
        user.setUserName("rahul");
        User user2 = new User();
        user2.setName("ABC");
        user2.setEmailId("ABC@123.com");
        user2.setPassword("123");
        user2.setUserName("ABC");
        User user2Inserted = iUserService.addUser(user2);
        User user1Inserted = iUserService.addUser(user);

        Group group = new Group();
        group.setName("Goa Trip");
        group.setUserId(1);
        Group inserted = iGroupService.addGroup(group);


        GroupUserMapping groupUserMapping = new GroupUserMapping();
        groupUserMapping.setGroupId(inserted.getId());
        groupUserMapping.setUserId(user1Inserted.getId());
        iGroupUserMappingService.addGroupUserMapping(groupUserMapping);
        GroupUserMapping groupUserMapping2 = new GroupUserMapping();
        groupUserMapping2.setGroupId(inserted.getId());
        groupUserMapping2.setUserId(user2Inserted.getId());
        iGroupUserMappingService.addGroupUserMapping(groupUserMapping2);

        Bill bill = new Bill();
        bill.setAmount(100);
        bill.setDescription("Hotel stay");
        bill.setUserId(user1Inserted.getId());
        Bill insertedBill = billService.addBill(bill);


        try {
            iSplitBillService.splitBillWithGroup(100, inserted.getId(), user1Inserted.getId(), insertedBill.getId());
        } catch (GroupNotFound groupNotFound) {
            groupNotFound.printStackTrace();
        } catch (UserNotFound userNotFound) {
            userNotFound.printStackTrace();
        }

        List<SplitBill> splitBill = iSplitBillService.getAllOweDetailsOfUser(user1Inserted.getId());
        Assert.isTrue(splitBill.size() == 1);
        Assert.isTrue(splitBill.get(0).getAmount() == 50);

    }


    @Test
    public void testPercentageWiseSplit() {
        User user = new User();
        user.setName("Rahul");
        user.setEmailId("rahul@123.com");
        user.setPassword("123");
        user.setUserName("rahul");
        User user2 = new User();
        user2.setName("ABC");
        user2.setEmailId("ABC@123.com");
        user2.setPassword("123");
        user2.setUserName("ABC");
        User user1Inserted = iUserService.addUser(user);
        User user2Inserted = iUserService.addUser(user2);

        Group group = new Group();
        group.setName("Goa Trip");
        group.setUserId(1);
        Group inserted = iGroupService.addGroup(group);


        GroupUserMapping groupUserMapping = new GroupUserMapping();
        groupUserMapping.setGroupId(inserted.getId());
        groupUserMapping.setUserId(user1Inserted.getId());
        iGroupUserMappingService.addGroupUserMapping(groupUserMapping);
        GroupUserMapping groupUserMapping2 = new GroupUserMapping();
        groupUserMapping2.setGroupId(inserted.getId());
        groupUserMapping2.setUserId(user2Inserted.getId());
        iGroupUserMappingService.addGroupUserMapping(groupUserMapping2);

        Bill bill = new Bill();
        bill.setAmount(100);
        bill.setDescription("Hotel stay");
        bill.setUserId(user1Inserted.getId());
        Bill insertedBill = billService.addBill(bill);


        try {
            iSplitBillService.splitBillPercentageWise(100, user1Inserted.getId(), insertedBill.getId(), new int[]{1, 10, 2, 90});
        } catch (GivenDataIsNotInProperFormat givenDataIsNotInProperFormat) {
            givenDataIsNotInProperFormat.printStackTrace();
        } catch (UserNotFound userNotFound) {
            userNotFound.printStackTrace();
        }
        List<SplitBill> splitBill = iSplitBillService.getAllOweDetailsOfUser(user1Inserted.getId());
        Assert.isTrue(splitBill.size() == 1);
        Assert.isTrue(splitBill.get(0).getAmount() == 90);
    }

}
