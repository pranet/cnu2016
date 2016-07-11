package com.cnu2016.nagarwal.controller;

import com.cnu2016.nagarwal.helpers.AWSSQSUtility;
import com.cnu2016.nagarwal.model.LogData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by niteshagarwal002 on 11/07/16.
 */

public class ModifiedInterceptor extends HandlerInterceptorAdapter{
    private LogData logData;

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        AWSSQSUtility awsSqsUtility = new AWSSQSUtility();
        logData = new LogData(httpServletRequest, httpServletResponse);
        String url = awsSqsUtility.getQueueUrl("cnu2016_nagarwal_assignment05");
        String res = new ObjectMapper().writeValueAsString(logData);
        awsSqsUtility.sendMessageToQueue(url,res);
    }
}