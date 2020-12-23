package com.rahul.splitwise.model;


import javax.persistence.*;

/**
 * The type Group user mapping.
 */
@Entity
@Table(name = "group_user_mapping")
public class GroupUserMapping {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "userId")
    private int userId;
    @Column(name = "groupId")
    private int groupId;

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
     * Gets group id.
     *
     * @return the group id
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     * Sets group id.
     *
     * @param groupId the group id
     */
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
