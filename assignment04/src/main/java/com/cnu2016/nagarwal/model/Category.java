package com.cnu2016.nagarwal.model;

import javax.persistence.*;

/**
 * Created by niteshagarwal002 on 08/07/16.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idCategory")
    private int id;
    private String categoryDescription;
    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
