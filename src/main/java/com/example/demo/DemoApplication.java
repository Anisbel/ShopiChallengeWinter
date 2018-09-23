package com.example.demo;

import com.example.demo.web.model.LineItem;
import com.example.demo.web.model.Order;
import com.example.demo.web.model.Product;
import com.example.demo.web.model.Shop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.demo.Dao.LineItemDaoImpl.lineItems;
import static com.example.demo.Dao.OrderDaoImp.orders;
import static com.example.demo.Dao.ProductDaoImpl.products;
import static com.example.demo.Dao.ShopDaoImp.shops;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}
}
