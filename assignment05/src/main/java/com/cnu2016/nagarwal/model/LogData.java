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
    private int ResponseCode;
    private String ipAddress;

    public LogData(){

    }
    public LogData(HttpServletRequest request, HttpServletResponse response){
        this.timestamp = new DateTime();
        this.url = request.getRequestURL().toString();
        this.ipAddress = request.getRemoteAddr();
        this.ResponseCode = response.getStatus();
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
