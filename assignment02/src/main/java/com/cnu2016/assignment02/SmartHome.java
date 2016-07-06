package com.cnu2016.assignment02;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
public class SmartHome {
    HashMap<Integer, Appliance> applianceMap;
    Appliance airConditioner;
    Appliance waterHeater;
    Appliance cookingOven;
    List events[];
    
    public static void main(String []args)throws FileNotFoundException{      
        SmartHome smartHome = new SmartHome();
        smartHome.initialize();
        smartHome.recordEvents();
        smartHome.executeTimeline();
    }
    
    public void initialize(){
        applianceMap = new HashMap<Integer, Appliance>();
        airConditioner = new Appliance(60, "Air Conditioner");
        waterHeater = new Appliance(2, "Water Heater");
        cookingOven = new Appliance(3, "Cooking Oven");
        
        applianceMap.put(1, airConditioner);
        applianceMap.put(2, waterHeater);
        applianceMap.put(3, cookingOven);
        
        events = new List[1000000];
        for(int i=0;i<100000;i++){
            events[i] = new ArrayList<Event>();
        }
    }
    public void recordEvents()throws FileNotFoundException{
        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            int time = input.nextInt();
            Appliance appliance = applianceMap.get(input.nextInt());
            boolean status = (input.nextInt()==0)?false:true;
            events[time].add(new Event(time,appliance,status));
            if(status){
                int defaultStopTime = time + appliance.getMaxRunningTime();
                events[defaultStopTime].add(new Event(defaultStopTime,appliance,!status));
            }
        }
    }
    public void executeTimeline(){
        for(int i=0;i<1000000;i++){
            List<Event> eventsAtGivenTime = events[i];
            try{
                for(int j=0;j<eventsAtGivenTime.size();j++){
                    Event currentEvent = eventsAtGivenTime.get(j);
                    performEvent(currentEvent);
                }
            }
            catch(NullPointerException e){
                
            }
        }
    }
    public void performEvent(Event e){
        Appliance appliance = e.getAppliance();
        int time = e.getTime();
        boolean status = e.getStatus();
        if(status){
            if(!appliance.getStatus()){
                appliance.switchOn(time);
                System.out.println(appliance.getName()+" started at Time: "+time);
            }
            else{
                System.out.println(appliance.getName()+" already running at Time: "+time);
            }
        }
        else{
            if(appliance.getStatus()){
                appliance.switchOff(time);
                System.out.println(appliance.getName()+" stopped at Time: "+time);
            }
            else{
                System.out.println(appliance.getName()+" already wasn't running at Time: "+time);
            }
            
        }
    }
    
}
