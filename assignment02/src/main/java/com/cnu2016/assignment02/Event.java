package com.cnu2016.assignment02;

public class Event {
    int time;
    Appliance appliance;
    boolean status;
    public Event(int time, Appliance appliance, boolean status){
        this.time=time;
        this.appliance = appliance;
        this.status = status;
    }
    public int getTime(){
        return time;
    }
    public Appliance getAppliance(){
        return appliance;
    }
    public boolean getStatus(){
        return status;
    }
}
