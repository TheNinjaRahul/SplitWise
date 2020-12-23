# SplitWise
Basic SplitWise Operation 

SplitWise:
=======================
1) Add user (name, email_id,username,password)  -- doable 
2) creatBill(groupID,BillAmouont,currentUser)   -- doable 
3) createBill(userIdsList{id1,id2},Amount,currentUser)  -- doable 
4) createGroup (useList{id1,id2....});  -- doable 
5) SSO (goodle,facebook)
6) fetchMyDetails(userId) - >  -- doable 
7) percentWiseDistribution( {{userid,%},{userid,%}...},amount)  -- doable 

 
In Memory DataBase: 
------------------
User{ id,name, email_id,username,password}
group{groupId,Name,userId}
groupMember(groupId,userid}
bill {id,amount,desc}
userOwe{userId,toUser,Amount,billId}


I have created SplitWise API's that will be used as to split bill.

<img src="Swagger.JPG"/>

As you can see in console i have created different kind of controllers based on its use cases.
User Controller:

This controller will be used to perform CRUD on User, It will also collect data of perticular user like how much amount i need to give to which users and how much amount i need to take back from other users.

I have used @query and join table in code it self to fetch data in custome format.

GroupController:
This controller will be used to perfrom CRUD on Group Enitiy.

UserGroupMappingController:
This controller will be used to create a mapping for one group to another user. 

  Enhancement: while creating a group we can pass list of users.
               We can pass list of users at same time while requesting to map this user to group.
               
BillController:
  This controller will be used to create a Bill and perform CRUD on it.
  Enhancement: while creating a bill  we can pass list of users and split method.
               
  As of now I have created seperate bill.
  
Split A Bill Controller:
   This controller will be used to split a Bill in group equally or wanted to split bill percentage wise. 
    
    Enhancement : As of now splitbill requires amount and bill id but in future we can directly fetch amount given bill id.
   
Exception Handler Controller:
  This controller will be used when any custome exceptions occred in our system.
  I am using ResponseEntity as response when exception occures.
  
I have created unit Test cases as well for each kind of services. 
  Enhancement: Many test cases are missing.

I am using ResponseEntity as response when exception occures.

I have used @query and join table in code it self to get the data.




