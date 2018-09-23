package com.example.demo.Dao;


import com.example.demo.web.model.Order;
import com.example.demo.web.model.Product;
import com.example.demo.web.model.Shop;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductDaoImpl {
    public static List<Product>products=new ArrayList<>();
    static {
        Product product=new Product();
        product.setName("Product test");
        //product.setLineItems();
        product.setProductId(1);
        product.setShopId(1);
        product.setValue(10);
        products.add(product);

    }

    public List<Product>findAll() {
        return products;
    }


    public Product findById(int id) {
        for (Product product : products) {
            if(product.getProductId() ==id){
                return product;
            }
        }
        return null;
    }


    public Product save(Product product) {
        products.add(product);
        return product;
    }

    public List<Product> findProductsByShopId(Integer shopId) {

        List <Product> productsByShopId= new ArrayList<>();
        for (Product product : products) {
            if(product.getShopId() ==shopId){
                productsByShopId.add(product);
            }
        }
        return productsByShopId;
    }

}