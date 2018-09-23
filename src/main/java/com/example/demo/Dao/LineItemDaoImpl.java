package com.example.demo.Dao;

import com.example.demo.web.model.LineItem;
import com.example.demo.web.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.Dao.OrderDaoImp.orders;


@Repository
public class LineItemDaoImpl {
    public static List<LineItem>lineItems=new ArrayList<>();
    static {
        LineItem item= new LineItem();
        item.setLineItemId(1);
        item.setName("item test name");
        item.setOrderId(1);
        item.setPrice(35);
        //item.setProductId();
        item.setQuantity(5);
        item.setRate(3);
        LineItem item2= new LineItem();
        item2.setLineItemId(2);
        item2.setName("item2 test name");
        item2.setOrderId(1);
        item2.setPrice(33);
        //item.setProductId();
        item2.setQuantity(2);
        item2.setRate(1);
        lineItems.add(item);
        lineItems.add(item2);
    }

    public List<LineItem>findAll() {
        return lineItems;
    }


    public LineItem findById(int id) {
        for (LineItem lineItem : lineItems) {
            if(lineItem.getLineItemId() ==id){
                return lineItem;
            }
        }
        return null;
    }


    public LineItem save(LineItem lineItem) {
        lineItems.add(lineItem);
        return lineItem;
    }

    public List<LineItem> findLineItemByOrderId(Integer orderId) {

        List <LineItem> LineItemByOrderId= new ArrayList<>();
        for (LineItem lineItem : lineItems) {
            if(lineItem.getOrderId() ==orderId){
                LineItemByOrderId.add(lineItem);
            }
        }
        return LineItemByOrderId;

    }

    public List<LineItem> findLineItemByProductsId(Integer productId) {

        List <LineItem> LineItemByProductId= new ArrayList<>();
        for (LineItem lineItem : lineItems) {
            if(lineItem.getProductId() ==productId){
                LineItemByProductId.add(lineItem);
            }
        }
        return LineItemByProductId;


    }
}
