package com.example.demo.Dao;
import com.example.demo.web.model.Order;
import com.example.demo.web.model.Shop;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
 public class  ShopDaoImp {
    public static List<Shop>shops= new ArrayList<>();
    static {
        Shop shopify= new Shop();
        shopify.setName("My coco Incubi.");
        shopify.setShopId(1);
        shops.add(shopify);
    }

    public static List<Shop>findAll() {
        return shops;
    }


    public static Shop findById(Integer id) {
        for (Shop shop : shops) {
            if(shop.getShopId() ==id){
                return shop;
            }
        }
        return null;
    }


    public static Shop save(Shop shop) {
        shops.add(shop);
        return shop;
    }
}
