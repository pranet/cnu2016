package com.cnu2016.assignment02;
import junit.framework.TestCase;

public class SmartHomeTest extends TestCase{
    public void testApplianceInitialization()throws Exception{
        SmartHome smartHomeObj = new SmartHome();
        smartHomeObj.initialize();
        assertEquals("Air Conditioner",smartHomeObj.airConditioner.getName());
        assertEquals(60,smartHomeObj.airConditioner.getMaxRunningTime());
    }
//    public void testRecordedEvents()throws Exception{
//        SmartHome smartHomeObj = new SmartHome();
//        smartHomeObj.initialize();
//        smartHomeObj.recordEvents();
//        Event event = (Event)smartHomeObj.events[1].get(0);
//        System.out.println(event.getTime()+" "+event.getAppliance().getName()+event.getStatus());
//        Appliance appliance = smartHomeObj.airConditioner;
//        Event expected = new Event(1,appliance,true);
//        assertEquals(expected, event);
//    }
}
