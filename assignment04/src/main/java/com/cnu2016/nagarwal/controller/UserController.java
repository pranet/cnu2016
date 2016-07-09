package com.cnu2016.nagarwal.controller;

import com.cnu2016.nagarwal.model.Feedback;
import com.cnu2016.nagarwal.repository.OrderProductRepository;
import com.cnu2016.nagarwal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by niteshagarwal002 on 09/07/16.
 */
public class UserController {
    @Autowired
    UserRepository userRepository;
    HttpHeaders responseHeaders = new HttpHeaders();

    public void OrderProductController() {
    }

    @RequestMapping(path="/api/users", method= RequestMethod.GET)
    public ResponseEntity<?> getUsers() {
//        List<Orders> order = new ArrayList<Orders>();
//        for(Orders o : repository.findAll()) {
//            order.add(o);
//        }
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Object>(userRepository.findAll(),responseHeaders, HttpStatus.OK);
    }
}

