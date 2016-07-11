package com.cnu2016.nagarwal.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by niteshagarwal002 on 08/07/16.
 */
@Entity
@Table(name="Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idOrder")
    private int id;
    private String orderStatus;
    @Column(columnDefinition = "datetime")
    private String orderDate;
    private double totalAmount;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User userOrdering;

    public User getUserOrdering() {
        return userOrdering;
    }

    public void setUserOrdering(User userOrdering) {
        this.userOrdering = userOrdering;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
