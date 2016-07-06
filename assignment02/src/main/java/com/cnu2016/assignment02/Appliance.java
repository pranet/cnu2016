package com.cnu2016.assignment02;
public class Appliance{
    private boolean status; //true indicates on false indicates off
    private int timeStarted;    //the time at which the appliance started running, -1 if the appliance is not running
    private int maxRunningTime; //the maximum amount of time for which an appliance runs independently
    private String name;
    public Appliance(int maxRunningTime, String name){
        setStatus(false);
        setTimeStarted(-1);
        setMaxRunningTime(maxRunningTime);
        setName(name);
    }
    public boolean getStatus(){
        return status;
    }
    public int getTimeStarted(){
        return timeStarted;
    }
    public int getMaxRunningTime(){
        return maxRunningTime;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    public void setTimeStarted(int timeStarted){
        this.timeStarted = timeStarted;
    }
    public void setMaxRunningTime(int maxRunningTime){
        this.maxRunningTime = maxRunningTime;
    }
    public void switchOn(int time){     //switching on an appliance
        setStatus(true);
        setTimeStarted(time);
    }
    public void switchOff(int time){     //switching off an appliance
        setStatus(false);
        setTimeStarted(-1);
    }
    @Override
    public boolean equals(Object obj) {
        Appliance appliance1 = this;
        Appliance appliance2 = (Appliance)obj;
        if(appliance1.getName()==appliance2.getName()&&appliance1.getMaxRunningTime()==appliance2.maxRunningTime)
            return true;
        else
            return false;
    }

}