package com.example.demo.web.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LineItem {
    @Id
     @GeneratedValue
     @Column(name = "LINEITEMID")
    private Integer lineItemId;

     @Column(name = "ORDERID")
    private Integer orderId;

      @Column(name = "PRODUCTID")
    private Integer productId;

      @Column(name = "PRICE")
    private Integer price;

      @Column(name = "RATE")
    private Integer rate;

      @Column(name = "QUANTITY")
    private Integer quantity;

      @Column(name = "NAME")
    private String name;

    public LineItem() {
    }

    public Integer getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(Integer lineItemId) {
        this.lineItemId = lineItemId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}