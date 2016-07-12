package com.cnu2016.nagarwal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by niteshagarwal002 on 08/07/16.
 */
@Entity
@Table(name = "Order_Product")
public class OrderProduct {
    @EmbeddedId
    private OrderProductCompositeId id;

    public OrderProductCompositeId getId() {
        return id;
    }

    public OrderProduct() {
    }

    public OrderProduct(OrderProductCompositeId id, int quantity, float sellPrice) {
        this.id = id;
        this.quantity = quantity;
        this.sellPrice = sellPrice;
    }

    public void setId(OrderProductCompositeId id) {
        this.id = id;

    }

    private int quantity;
    private float sellPrice;



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }
}


