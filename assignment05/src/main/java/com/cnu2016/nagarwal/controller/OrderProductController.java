package com.cnu2016.nagarwal.controller;

import com.cnu2016.nagarwal.model.*;
import com.cnu2016.nagarwal.repository.OrderProductRepository;
import com.cnu2016.nagarwal.repository.OrderRepository;
import com.cnu2016.nagarwal.repository.ProductRepository;
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
public class OrderProductController {

    @Autowired
    OrderProductRepository orderProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    HttpHeaders responseHeaders = new HttpHeaders();

    public void OrderProductController() {
    }

    @RequestMapping(path="/api/ordersproducts", method= RequestMethod.GET)
    public ResponseEntity<?> getOrders() {
//        List<Orders> order = new ArrayList<Orders>();
//        for(Orders o : repository.findAll()) {
//            order.add(o);
//        }
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Object>(orderProductRepository.findAll(),responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(path="/api/ordersproducts/{oid}/{pid}", method=RequestMethod.GET)
    public OrderProduct getProduct(@PathVariable Integer oid, @PathVariable Integer pid) {
        Product product = productRepository.findOne(pid);
        Orders orders = orderRepository.findOne(oid);
        if(product!=null&&orders!=null) {
            OrderProductCompositeId orderProductCompositeId = new OrderProductCompositeId(product,orders);
            return orderProductRepository.findOne(orderProductCompositeId);
//            responseHeaders.setContentType(MediaType.APPLICATION_JSON);
//            if (repository.exists(id) && product.isAvailable())
//                return new ResponseEntity<Object>(product, responseHeaders, HttpStatus.OK);
//            else
//                return new ResponseEntity<Object>("{\"detail\":\"Not found.\"}", responseHeaders, HttpStatus.NOT_FOUND);
        }
        return null;
    }

    @RequestMapping(path = "/api/orders/{oid}/orderLineItem", method = RequestMethod.POST)
    public ResponseEntity<?> addItemtoOrder(@RequestBody ItemFromCart itemFromCart, @PathVariable Integer oid){
        if(orderRepository.exists(oid) && productRepository.exists(itemFromCart.getProduct_id())) {
            Product product = productRepository.findOne(itemFromCart.getProduct_id());
            if(!product.isAvailable()||product.getQty()<itemFromCart.getQty()){
                return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
            }
            Orders orders = orderRepository.findOne(oid);
            OrderProductCompositeId orderProductCompositeId = new OrderProductCompositeId(product, orders);
            OrderProduct orderProduct = new OrderProduct(orderProductCompositeId, itemFromCart.getQty(), product.getSellPrice());
            if(orderProductRepository.exists(orderProductCompositeId)){
                orderProduct = orderProductRepository.findOne(orderProductCompositeId);
            }
            if(orderProduct.getQuantity()+itemFromCart.getQty()<product.getQty())
                return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
            orderProduct.setQuantity(orderProduct.getQuantity()+itemFromCart.getQty());
            orderProductRepository.save(orderProduct);
            responseHeaders.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<Object>(orderProduct, responseHeaders, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
    }
}
