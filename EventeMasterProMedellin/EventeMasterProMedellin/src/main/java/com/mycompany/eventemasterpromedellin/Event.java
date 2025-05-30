
package com.mycompany.eventemasterpromedellin;


import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
    private int id;
    private String name;
    private LocalDate date;
    private LocalTime time;
    private String location;
    private String category;
    
    public Event(int id, String name, LocalDate date, LocalTime time, String location, String category){
        this.id = id;
        this.name = name;
        this.date  = date;
        this.time = time;
        this.location = location;
        this.category = category;
    
    }
    
    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    
    public String getName() {return name;}
    public void setName(String name){this.name = name;}
    
    public LocalDate getDate(){return date;}
    public void setDate(LocalDate date){this.date = date;}
    
    public LocalTime getTime(){return time;}
    public void setTime(LocalTime time){this.time = time;}
    
    public String getLocation() { return location; }
    public void setLocation(String location){this.location = location;}
    public String getCategory(){return category;}
    public void setCategory(String category){this.category = category;}
     
    public void editEvent(String name, LocalDate date, LocalTime time, String location, String category){
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.category = category;
    } 
    
    @Override
    public String toString(){
        return  "Event ID: " + id + ", Name: " + name + ", date: " + date + ", Time: " + time + ", Location: " + location + ", Category: " + category;
    
    }
}

