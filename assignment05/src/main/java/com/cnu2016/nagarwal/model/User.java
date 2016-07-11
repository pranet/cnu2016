package com.cnu2016.nagarwal.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by niteshagarwal002 on 08/07/16.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;
    private String userName;
    private String userEmail;
    private String userAddress;
    private String userContactNumber;
    private String contactPerson;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
//    private Set<Feedback> feedbacks;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userOrdering", cascade = CascadeType.ALL)
//    private  Set<Orders> orders;

//    public Set<Orders> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(Set<Orders> orders) {
//        this.orders = orders;
//    }

//    public Set<Feedback> getFeedbacks() {
//        return feedbacks;
//    }
//
//    public void setFeedbacks(Set<Feedback> feedbacks) {
//        this.feedbacks = feedbacks;
//    }

    public User(String userName, String userEmail, String userAddress, String userContactNumber, String contactPerson) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userContactNumber = userContactNumber;
        this.contactPerson = contactPerson;
    }

    public User() {

    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int id) {
        this.idUser = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserContactNumber() {
        return userContactNumber;
    }

    public void setUserContactNumber(String userContactNumber) {
        this.userContactNumber = userContactNumber;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
}
