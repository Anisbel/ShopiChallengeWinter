package com.example.demo.Dao;
import com.example.demo.web.model.Order;
import com.example.demo.web.model.Shop;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDaoImp {
    public static List<Order>orders= new ArrayList<>();


    static {
        Order order1=new Order();
        order1.setName("Order 1");
        order1.setOrderId(1);
        order1.setShopId(1);
        orders.add(order1);
    }


    public List<Order>findAll() {
        return orders;
    }


    public Order findById(int id) {
        for (Order order : orders) {
            if(order.getOrderId() ==id){
                return order;
            }
        }
        return null;
    }


    public Order save(Order order) {
        orders.add(order);
        return order;
    }

    public List<Order> findOrderByShopId(Integer shopId) {

     List <Order> ordersByShopId= new ArrayList<>();
        for (Order order : orders) {
            if(order.getShopId() ==shopId){
                ordersByShopId.add(order);
            }
        }
        return ordersByShopId;

    }
}
