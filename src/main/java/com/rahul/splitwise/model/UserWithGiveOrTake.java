package com.rahul.splitwise.model;

/**
 * The type User with give or take.
 */
public class UserWithGiveOrTake {

    private String userName;
    private double amount;

    /**
     * Instantiates a new User with give or take.
     *
     * @param userName the user name
     * @param amount   the amount
     */
    public UserWithGiveOrTake(String userName, double amount) {
        this.userName = userName;
        this.amount = amount;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
}
