package com.cnu2016.nagarwal.controller;

import com.cnu2016.nagarwal.model.CheckoutDetails;
import com.cnu2016.nagarwal.model.Orders;
import com.cnu2016.nagarwal.model.User;
import com.cnu2016.nagarwal.repository.OrderRepository;
import com.cnu2016.nagarwal.repository.ProductRepository;
import com.cnu2016.nagarwal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by niteshagarwal002 on 09/07/16.
 */
@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderProductRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    HttpHeaders responseHeaders = new HttpHeaders();

    @RequestMapping(path="/api/orders", method= RequestMethod.GET)
    public ResponseEntity<?> getOrders() {
//        List<Orders> order = new ArrayList<Orders>();
//        for(Orders o : orderProductRepository.findAll()) {
//            order.add(o);
//        }
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Object>(orderProductRepository.findAll(),responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(path="/api/order", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(){
        Orders order = new Orders();
        orderProductRepository.save(order);
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Object>(order,responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(path="/api/order/{oid}", method= RequestMethod.PATCH)
    public ResponseEntity<?> checkoutOrder(@RequestBody CheckoutDetails checkoutDetails, @PathVariable Integer oid){
        User user = new User();
        user = userRepository.findUniqueByUserName(checkoutDetails.getUserName());
        if(user==null){
            user = new User(checkoutDetails.getUserName(),checkoutDetails.getUserEmail(),checkoutDetails.getUserAddress(),checkoutDetails.getUserContactNumber(),checkoutDetails.getContactPerson());
            userRepository.save(user);
        }
        Orders orders = orderRepository.findOne(oid);
        orders.setOrderStatus(checkoutDetails.getStatus());
        orders.setUserOrdering(user);
        orderRepository.save(orders);
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Object>(orders,responseHeaders, HttpStatus.OK);
    }
}
