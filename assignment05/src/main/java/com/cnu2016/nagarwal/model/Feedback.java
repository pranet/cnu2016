package com.cnu2016.nagarwal.model;

import javax.persistence.*;

/**
 * Created by niteshagarwal002 on 08/07/16.
 */
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "idFeedback")
    private int id;
    @Column(name="description")
    private String message;
    private String type;
    @Column(columnDefinition = "timestamp")
    private String timestamp;
    private String userEmail;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
