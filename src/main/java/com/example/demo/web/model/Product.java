package com.example.demo.web.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Product {
       @Id
       @GeneratedValue
       @Column(name = "PRODUCTID")
    private Integer productId;

       @OneToMany(cascade={CascadeType.ALL})
       @JoinColumn(name="PRODUCTID")
    private List<LineItem> lineItems;

     @Column(name = "VALUE")
    private Integer value;

      @Column(name = "NAME")
    private String name;

      @Column(name = "SHOPID")
    private Integer shopId;

    public Product() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
}