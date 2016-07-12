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
    public List<OrderProduct> listOrderProducts(int orderId){
        Iterable<OrderProduct> iterableOrderProduct = orderProductRepository.findAll();
        List<OrderProduct> listOrderProduct = new ArrayList<>();
        iterableOrderProduct.forEach(listOrderProduct::add);
        List<OrderProduct> results = new ArrayList<>();
        for(OrderProduct item: listOrderProduct){
            if(item.getId().getOrders().getId()==orderId){
                results.add(item);
            }
        }
        return results;
    }

}
