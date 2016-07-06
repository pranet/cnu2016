package com.cnu2016.assignment02;

import junit.framework.TestCase;

public class EventTest extends TestCase {
	public void testEventClass(){
		Appliance appliance = new Appliance(5, "test appliance");
		Event event = new Event(4, appliance, true);
		assertEquals(true, event.getStatus());
		assertEquals(4,event.getTime());
		assertEquals(appliance,event.getAppliance());
		
	}
	public void testEquals(){
	    Appliance appliance = new Appliance(5, "test appliance");
		Event event1 = new Event(4, appliance, true);
		Event event2 = new Event(4, appliance, true);
		assertEquals(event1,event2);
	}
	public void testNotEquals(){
	    Appliance appliance = new Appliance(5, "test appliance");
		Event event1 = new Event(4, appliance, true);
		Event event2 = new Event(4, appliance, false);
		assertEquals(false,event1.equals(event2));
	}

}
