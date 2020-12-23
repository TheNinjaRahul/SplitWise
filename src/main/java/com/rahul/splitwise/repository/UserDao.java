package com.rahul.splitwise.repository;


import com.rahul.splitwise.model.User;
import com.rahul.splitwise.model.UserWithGiveOrTake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    @Query("select new com.rahul.splitwise.model.UserWithGiveOrTake(b.name,a.amount) from SplitBill a,User b where a.userId=?1 and a.dueUserId=b.id")
    public List<UserWithGiveOrTake> getAllDataThatUserNeedToTake(int useId);

    @Query("select new com.rahul.splitwise.model.UserWithGiveOrTake(b.name,a.amount) from SplitBill a,User b where a.dueUserId=?1 and a.userId=b.id")
    public List<UserWithGiveOrTake> getAllDataThatUserNeedToGive(int useId);
}
