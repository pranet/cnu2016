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
	    Appliance appliance2 = new Appliance(5, "test appliance 2");	 
	    Appliance appliance3 = new Appliance(4, "test appliance 2");	 
		Event event1 = new Event(4, appliance, true);
		Event event2 = new Event(4, appliance, false);
		Event event3 = new Event(4, appliance2, false);
		Event event4 = new Event(5, appliance, false);	
		Event event5 = new Event(4, appliance3, false);	
		assertEquals(false,event1.equals(event2));
		assertEquals(false,event3.equals(event2));
		assertEquals(false,event4.equals(event2));
		assertEquals(false,event3.equals(event5));
		
	}

}
