package com.example.demo.web.model;

import javax.persistence.*;
import java.util.List;

 @Entity
public class Shop {

        @Id
        @GeneratedValue
        @Column(name = "SHOPID")
        private Integer shopId;

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="SHOPID")
    private List<Order> orders;

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="SHOPID")
    private List<Product> products;

    @Column(name = "NAME")
    private String name;

    public Shop() {
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}