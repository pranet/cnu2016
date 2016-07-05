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
        SmartHome smartHomeObj = new SmartHome();
        smartHomeObj.main(null);
        assertEquals("Air Conditioner",smartHomeObj.airConditioner.getName());
    }
}
