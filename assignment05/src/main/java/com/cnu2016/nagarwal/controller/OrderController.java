package com.cnu2016.nagarwal.controller;

import com.cnu2016.nagarwal.helpers.OrderServices;
import com.cnu2016.nagarwal.model.*;
import com.cnu2016.nagarwal.repository.OrderProductRepository;
import com.cnu2016.nagarwal.repository.OrderRepository;
import com.cnu2016.nagarwal.repository.ProductRepository;
import com.cnu2016.nagarwal.repository.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by niteshagarwal002 on 09/07/16.
 */
@RestController
public class OrderController {
    @Autowired
    private OrderProductRepository orderProductRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    HttpHeaders responseHeaders = new HttpHeaders();

    @RequestMapping(path="/api/orders/{oid}", method= RequestMethod.GET)
    public ResponseEntity<?> getOrder(@PathVariable Integer oid) {
        Orders orders = orderRepository.findOne(oid);
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        if(orderRepository.exists(oid))
            return new ResponseEntity<Object>(orders,responseHeaders,HttpStatus.OK);
        else
            return new ResponseEntity<Object>("{\"detail\":\"Not found.\"}",responseHeaders,HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path="/api/orders", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(){
        Orders order = new Orders();
        orderRepository.save(order);
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Object>(order,responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(path="/api/orders/{oid}", method= RequestMethod.PATCH)
    public ResponseEntity<?> checkoutOrder(@RequestBody CheckoutDetails checkoutDetails, @PathVariable Integer oid){
        User user = userRepository.findUniqueByUserName(checkoutDetails.getUser_name());
        if(user==null){
            user = new User(checkoutDetails.getUser_name(),checkoutDetails.getUserEmail(),checkoutDetails.getAddress(),checkoutDetails.getUserContactNumber(),checkoutDetails.getContactPerson());
            userRepository.save(user);
        }
        Orders orders = orderRepository.findOne(oid);
        orders.setOrderStatus(checkoutDetails.getStatus());
        orders.setUserOrdering(user);
        orderRepository.save(orders);
        OrderServices orderServices = new OrderServices();
        List<OrderProduct> listOrderProducts = orderServices.listOrderProducts(oid);
        for(OrderProduct item:listOrderProducts){
            Product product = productRepository.findOne(item.getId().getProduct().getId());
            product.setQty(product.getQty()-item.getQuantity());
            productRepository.save(product);
        }
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Object>(orders,responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(path="/api/orders/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrder(@PathVariable Integer id) {
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        if(orderRepository.exists(id)) {
            OrderServices orderServices = new OrderServices();
            List<OrderProduct> listOrderProducts = orderServices.listOrderProducts(id);
            for(OrderProduct item:listOrderProducts){
                orderProductRepository.delete(item);
            }
            orderRepository.delete(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<Object>("{\"detail\":\"Not found.\"}",responseHeaders,HttpStatus.NOT_FOUND);
        }
    }
}
