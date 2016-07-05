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

}
