package com.cnu2016.nagarwal.helpers;

import com.cnu2016.nagarwal.model.OrderProduct;
import com.cnu2016.nagarwal.repository.OrderProductRepository;
import com.cnu2016.nagarwal.repository.OrderRepository;
import com.cnu2016.nagarwal.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by niteshagarwal002 on 12/07/16.
 */
public class OrderServices {
    @Autowired
    OrderProductRepository orderProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
//    public Iterable<OrderProduct> listOrderProducts(int orderId){
//        Iterable<OrderProduct> iterableOrderProduct = orderProductRepository.findAll();
//        Iterable<OrderProduct> results = new ArrayList<>();
//        for(OrderProduct item: iterableOrderProduct){
//            if(item.getId().getOrders().getId()==orderId){
//                results.;
//                System.out.println(item.getQuantity());
//            }
//        }
//        return results;
//    }

}
