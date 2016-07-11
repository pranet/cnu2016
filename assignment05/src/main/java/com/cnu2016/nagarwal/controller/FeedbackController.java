package com.cnu2016.nagarwal.controller;

import com.cnu2016.nagarwal.model.Feedback;
import com.cnu2016.nagarwal.repository.FeedbackRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niteshagarwal002 on 09/07/16.
 */
@RestController
public class FeedbackController {
    @Autowired
    FeedbackRespository feedbackRespository;
    HttpHeaders responseHeaders = new HttpHeaders();

    public void OrderProductController() {
    }

    @RequestMapping(path="/api/feedbacks", method= RequestMethod.GET)
    public ResponseEntity<?> getFeedbacks() {
//        List<Orders> order = new ArrayList<Orders>();
//        for(Orders o : repository.findAll()) {
//            order.add(o);
//        }
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Object>(feedbackRespository.findAll(),responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(path="/api/contactus", method = RequestMethod.POST)
    public ResponseEntity<?> postFeedBack(@RequestBody Feedback feedback){
        feedbackRespository.save(feedback);
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Object>(feedback,responseHeaders, HttpStatus.CREATED);

    }
}