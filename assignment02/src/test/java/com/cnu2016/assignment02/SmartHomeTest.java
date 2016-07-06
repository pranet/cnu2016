package com.cnu2016.assignment02;
import junit.framework.TestCase;
import java.io.*;
public class SmartHomeTest extends TestCase{

    public void testApplianceInitialization()throws Exception{
        SmartHome smartHomeObj = new SmartHome();
        smartHomeObj.initialize();
        assertEquals("Air Conditioner",smartHomeObj.airConditioner.getName());
        assertEquals(60,smartHomeObj.airConditioner.getMaxRunningTime());
    }
    public void testRecordedEvents()throws Exception{
        SmartHome smartHomeObj = new SmartHome();
        smartHomeObj.initialize();
        smartHomeObj.recordEvents("input.txt");
        Event event = (Event)smartHomeObj.events[1].get(0);
        System.out.println(event.getTime()+" "+event.getAppliance().getName()+event.getStatus());
        Appliance appliance = smartHomeObj.waterHeater;
        Event expected = new Event(1,appliance,true);
        assertEquals(expected, event);
    }
    public void testPerformEventMethod()throws Exception{
        SmartHome smartHomeObj = new SmartHome();
        Appliance appliance = new Appliance(5, "test appliance");
		Event event = new Event(4, appliance, true);
        String actualResult = smartHomeObj.performEvent(event);
        assertEquals("test appliance started at Time: 4",actualResult);
    }
    public void testExecuteTimeLineMethod()throws Exception{
        SmartHome smartHomeObj = new SmartHome();
        smartHomeObj.initialize();
        Appliance appliance = new Appliance(5, "test appliance");
		Event event = new Event(4, appliance, true);
		smartHomeObj.events[4].add(event);
		smartHomeObj.executeTimeline();
        assertEquals(true, appliance.getStatus());
    }
    public void testStartSmartHomeMethod()throws Exception{
        SmartHome smartHomeObj = new SmartHome();
        smartHomeObj.startSmartHome(smartHomeObj, "input1.txt");
        assertEquals(false, smartHomeObj.waterHeater.getStatus());
        
    }
}
