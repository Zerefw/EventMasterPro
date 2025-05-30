
package com.mycompany.eventemasterpromedellin;


public class Ticket {
    private int id;
    private int eventId;
    private String type;
    private double price;
    private boolean isSold;
    
    public Ticket(int id, int eventId, String type, double price, boolean Sold){
        this.id = id;
        this.eventId = eventId;
        this.type = type;
        this.price = price;
        this.isSold = false;    
    }
    
    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    
    public int getEventId(){return eventId;}
    public void setEventId(int eventId){this.eventId = eventId;}
    
    public String getType(){return type;}
    public void setType(String type){this.type = type;}
    
    public double getPrice(){return price;}
    public void setPrice(double price){this.price = price;}
    
    public boolean isSold(){return isSold;}
    public void setSold(boolean isSold){this.isSold = isSold;}
    
    public void sellTicket(){
        if (!isSold){
            isSold = true;
            System.out.println("Ticket sold");
        }else{
            System.out.println("Ticket is already sold.");
        }
    }
    
    public void validateTicket(){
        if (isSold){
            System.out.println("Ticket is valid.");
        }else{
            System.out.println("Ticket is not valid.");
        }
    }
    
    @Override
    public String toString(){
        return "Ticket ID: " + id + ", Event ID: " + eventId + ", Type: " + type + ", Price: " + price + ", Sold: " + isSold;
    }
}
