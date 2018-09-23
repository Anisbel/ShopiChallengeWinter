package com.example.demo.web.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {

       @Id
       @GeneratedValue
       @Column(name = "ORDERID")
    private Integer orderId;

      @OneToMany(cascade={CascadeType.ALL})
      @JoinColumn(name="ORDERID")
    private List<LineItem> lineItems;

      @Column(name = "NAME")
    private String name;

      @Column(name = "SHOPID")
    private Integer shopId;


    // not in the database
    private Integer totalValue;


    public Order() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Integer getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Integer totalValue) {
        this.totalValue = totalValue;
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