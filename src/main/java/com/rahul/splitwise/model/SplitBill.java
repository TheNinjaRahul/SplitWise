package com.rahul.splitwise.model;


import javax.persistence.*;

@Entity
@Table(name = "bill_split")
public class SplitBill {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "due_user_id")
    private int dueUserId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "bill_id")
    private int billId;

    @Column(name = "isPaid")
    private boolean isPaid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDueUserId() {
        return dueUserId;
    }

    public void setDueUserId(int dueUserId) {
        this.dueUserId = dueUserId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
