package com.cnu2016.assignment02;

import junit.framework.TestCase;

public class ApplianceTest extends TestCase {
	public void testApplianceClassGetters(){
		Appliance appliance = new Appliance(5,"Test Appliance");
		assertEquals("Test Appliance", appliance.getName());
		assertEquals(5, appliance.getMaxRunningTime());
		assertEquals(false, appliance.getStatus());
		assertEquals(-1,appliance.getTimeStarted());
	}
	public void testApplianceClassConstructor(){
		Appliance appliance = new Appliance(5,"Test Appliance");
		assertEquals("Test Appliance", appliance.getName());
		assertEquals(5, appliance.getMaxRunningTime());
	}
	public void testApplianceClassSetters(){
		Appliance appliance = new Appliance(0,"");
		appliance.setMaxRunningTime(5);
		appliance.setName("Test Appliance");
		appliance.setStatus(false);
		appliance.setTimeStarted(0);
		assertEquals("Test Appliance", appliance.getName());
		assertEquals(5, appliance.getMaxRunningTime());
		assertEquals(false, appliance.getStatus());
		assertEquals(0,appliance.getTimeStarted());
	}
	public void testSwitchOnMethod(){
		Appliance appliance = new Appliance(5,"Test Appliance");
		appliance.switchOn(4);
		assertEquals(true, appliance.getStatus());
		assertEquals(4,appliance.getTimeStarted());
	}
	public void testSwitchOffMethod(){
		Appliance appliance = new Appliance(5,"Test Appliance");
		appliance.switchOff(4);
		assertEquals(false, appliance.getStatus());
	}
	public void testEquals(){
	    Appliance appliance1 = new Appliance(5,"Test Appliance");
	    Appliance appliance2 = new Appliance(5,"Test Appliance");
	    assertEquals(appliance1,appliance2);
	    
	}
	public void testNotEquals(){
	    Appliance appliance1 = new Appliance(5,"Test Appliance");
	    Appliance appliance2 = new Appliance(6,"Test Appliance");
	    Appliance appliance3 = new Appliance(6,"Test Appliance 3");	    
	    assertEquals(false,appliance1.equals(appliance2));
	    assertEquals(false,appliance2.equals(appliance3));
	}
}
