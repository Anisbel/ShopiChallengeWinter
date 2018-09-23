package com.example.demo.web.controller;
import com.example.demo.Dao.LineItemDaoImpl;
import com.example.demo.Dao.OrderDaoImp;
import com.example.demo.Dao.ProductDaoImpl;
import com.example.demo.Dao.ShopDaoImp;
import com.example.demo.web.model.LineItem;
import com.example.demo.web.model.Order;
import com.example.demo.web.model.Product;
import com.example.demo.web.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestApiController {


    @Autowired
    private ProductDaoImpl productDao;
    @Autowired
    private ShopDaoImp shopDao;
    @Autowired
    private OrderDaoImp orderDao;
    @Autowired
    private LineItemDaoImpl lineItemDao;



    @GetMapping("/api/shop/{shopId}")
    public Shop getShop(@PathVariable Integer shopId) {

        Shop shop = shopDao.findById(shopId);
        List<Order> orders=orderDao.findOrderByShopId(shopId);
        List<Product> products=productDao.findProductsByShopId(shopId);

        setTotalValue(orders);
        mapLineItemValueToProduct(products);

        return shop;
    }

    @GetMapping("/api/shop/{shopId}/product")
    public List<Product> getAllProducts( @PathVariable Integer shopId) {

        List<Product> products=productDao.findProductsByShopId(shopId);

        mapLineItemValueToProduct(products);

        return products;
    }

    @GetMapping("/api/shop/{shopId}/order")
    public List<Order> getAllOrders( @PathVariable Integer shopId) {

        List<Order> orders=orderDao.findOrderByShopId(shopId);

        setTotalValue(orders);

        return orders;
    }


    @GetMapping("/api/shop/{shopId}/order/{orderId}")
    public Order getOrder(@PathVariable Integer orderId,@PathVariable Integer shopId)
             {

        Order order = this.orderDao.findById(orderId);

        Integer orderShopId = order.getShopId();

        if (shopId.equals(orderShopId)) {

            setTotalValue(order);

            return order;
        }

        else {
            return null;
        }
    }

    @GetMapping("/api/shop/{shopId}/product/{productId}")
    public Product getProduct( @PathVariable Integer productId, @PathVariable Integer shopId)  {

        Product product = this.productDao.findById(productId);

        Integer productShopId = product.getShopId();

        if (shopId.equals(productShopId)) {
            mapLineItemValueToProduct(product);
            return product;
        }

        else {
            return null;
        }

    }


    private void setTotalValue(Order order) {

        List<LineItem> items = this.lineItemDao.findLineItemByOrderId(order.getOrderId());

        Integer price = 0;

        for (LineItem item : items) {
            price += item.getPrice();
        }

        order.setTotalValue(price);
    }


    private void setTotalValue(List<Order> orders) {

        for (Order order : orders) {
            setTotalValue(order);
        }
    }


    private void mapLineItemValueToProduct(Product product) {

        List<LineItem> items = this.lineItemDao.findLineItemByProductsId(product.getProductId());

        Integer value = product.getValue();

        for (LineItem item : items) {
            item.setPrice(value);
        }
    }

    private void mapLineItemValueToProduct(List<Product> products) {

        for (Product product: products) {
            mapLineItemValueToProduct(product);
        }
    }
}


