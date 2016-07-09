package com.cnu2016.nagarwal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niteshagarwal002 on 10/07/16.
 */
@RestController
public class TestController {
    @RequestMapping(path="/api", method = RequestMethod.GET)
    public ResponseEntity<?> serverStatus(){
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }
}
