package com.cnu2016.assignment02;
import java.io.*;
import junit.framework.TestCase;

public class SmartHomeTest extends TestCase{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
}

public void cleanUpStreams() {
    System.setOut(null);
    System.setErr(null);
}
    public void testAppliance()throws Exception{
        SmartHome.main(null);
        System.out.println(outContent.toString());
        assertEquals("Water Heater started at Time: 1\nWater Heater stopped at Time: 3\nCooking Oven already wasn't running at Time: 3\nAir Conditioner started at Time: 4\nWater Heater already wasn't running at Time: 7\nAir Conditioner stopped at Time: 64",outContent.toString());
    }
}
