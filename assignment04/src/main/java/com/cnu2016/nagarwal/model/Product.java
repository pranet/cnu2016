package com.cnu2016.nagarwal.model;

/**
 * Created by niteshagarwal002 on 07/07/16.
 */
import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idProduct")
    private int id;
    private String productName;
    @Column(name="productDescription")
    private String description;
    private String brand;
    private float sellPrice;
    private float buyPrice;
    private int itemInStock;
    @Column(name="productCode")
    private String code;
    private boolean available;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getItemInStock() {

        return itemInStock;
    }

    public void setItemInStock(int itemInStock) {
        this.itemInStock = itemInStock;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public Product(){
    }
    public void putProductProperties(Product p){
        this.setAvailable(p.isAvailable());
        this.setBrand(p.getBrand());
        this.setSellPrice(p.getSellPrice());
        this.setBuyPrice(p.getBuyPrice());
        this.setCode(p.getCode());
        this.setDescription(p.getDescription());
        this.setItemInStock(p.getItemInStock());
        this.setProductName(p.getProductName());
    }
    public void patchProductProperties(Product p){
        if (p.getBrand()!=null)
            this.setBrand(p.getBrand());
        if (p.getBuyPrice()!=0.0)
            this.setSellPrice(p.getSellPrice());
        if(p.getSellPrice()!=0.0)
            this.setBuyPrice(p.getBuyPrice());
        if(p.getCode()!=null)
            this.setCode(p.getCode());
        if(p.getDescription()!=null)
            this.setDescription(p.getDescription());
        if(p.getProductName()!=null)
            this.setProductName(p.getProductName());
    }
}
