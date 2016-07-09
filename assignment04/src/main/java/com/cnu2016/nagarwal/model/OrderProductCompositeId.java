package com.cnu2016.nagarwal.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by niteshagarwal002 on 09/07/16.
 */

@Embeddable
public class OrderProductCompositeId implements Serializable {
    @ManyToOne
    @JoinColumn(name="idProduct")
    private Product product;
    @ManyToOne
    @JoinColumn(name="idOrder")
    private Orders orders;

    public OrderProductCompositeId(){

    }
    public OrderProductCompositeId(Product product, Orders orders){
        this.product = product;
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}