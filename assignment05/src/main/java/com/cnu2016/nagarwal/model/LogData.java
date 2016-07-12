package com.cnu2016.nagarwal.model;

import org.joda.time.DateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by niteshagarwal002 on 11/07/16.
 */
public class LogData {
    private DateTime timestamp;
    private String url;
    private String parameters;
    private int ResponseCode;
    private String ipAddress;
    private int requestDuration;
    private String requestType;

    public LogData(){

    }
    public LogData(HttpServletRequest request, HttpServletResponse response,long totalTime){
        this.timestamp = new DateTime();
        String completeRequestUrl = request.getRequestURL().toString();
        if(completeRequestUrl.indexOf('?')<0) {
            this.url = completeRequestUrl;
            this.parameters = "";
        }
        else {
            int questionMarkIndex = completeRequestUrl.indexOf("?");
            this.url = completeRequestUrl.substring(0,questionMarkIndex);
            this.parameters = completeRequestUrl.substring(questionMarkIndex+1,completeRequestUrl.length());
        }
        this.ipAddress = request.getRemoteAddr();
        this.parameters = request.getParameterMap().toString();
        this.ResponseCode = response.getStatus();
        this.requestType = request.getMethod();
        this.requestDuration = (int)totalTime;
    }

    public int getRequestDuration() {
        return requestDuration;
    }

    public void setRequestDuration(int requestDuration) {
        this.requestDuration = requestDuration;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public DateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(DateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public int getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(int responseCode) {
        ResponseCode = responseCode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
