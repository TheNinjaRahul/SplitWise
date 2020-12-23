package com.rahul.splitwise.model;


import javax.persistence.*;

/**
 * The type Split bill.
 */
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

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets due user id.
     *
     * @return the due user id
     */
    public int getDueUserId() {
        return dueUserId;
    }

    /**
     * Sets due user id.
     *
     * @param dueUserId the due user id
     */
    public void setDueUserId(int dueUserId) {
        this.dueUserId = dueUserId;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets bill id.
     *
     * @return the bill id
     */
    public int getBillId() {
        return billId;
    }

    /**
     * Sets bill id.
     *
     * @param billId the bill id
     */
    public void setBillId(int billId) {
        this.billId = billId;
    }

    /**
     * Is paid boolean.
     *
     * @return the boolean
     */
    public boolean isPaid() {
        return isPaid;
    }

    /**
     * Sets paid.
     *
     * @param paid the paid
     */
    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
