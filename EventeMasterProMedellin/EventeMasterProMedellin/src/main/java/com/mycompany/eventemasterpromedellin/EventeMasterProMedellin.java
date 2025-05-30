

package com.mycompany.eventemasterpromedellin;

import java.time.LocalDate;
import java.time.LocalTime;
import java.io.*;
import java.util.Scanner;

public class EventeMasterProMedellin {
    private static final String EVENTS_FILE = "data/event.txt"; 
    private static final String VENUES_FILE = "data/venue.txt"; 
    private static final String ARTIST_FILE = "data/artists.txt"; 
    private static final String TICKET_FILE = "data/tickets.txt";
    
    private static final Scanner scanner =  new Scanner(System.in);
    private static final AccessControl accessControl = new AccessControl();
    
    public static void main(String[] args) {
        createDataDirectory();
        int option;
        
        do{
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            
            switch(option){
                case 1 -> createEvent();
                case 2 -> listFromFile(EVENTS_FILE);
                case 3 -> createVenue();
                case 4 -> listFromFile(VENUES_FILE);
                case 5 -> registerArtist();
                case 6 -> listFromFile(ARTIST_FILE);
                case 7 -> createTicket();
                case 8 -> sellTicket();
                case 9 -> registerAttendee();
                case 10 -> accessControl.generateAttendanceStats();
                case 0 -> System.out.println("Exiting EvenMaster Pro Medellin. Goodbye!");
                default -> System.out.println("Invalid option. please try again.");              
            }        
       }while(option !=0);
    }
    
    private static void createDataDirectory(){
        File dir = new File("data");
        if (!dir.exists())dir.mkdirs();
    }
    
    private static void showMenu(){
        System.out.println("\n--- EventMaster Pro Medellin Menu ---");
        System.out.println("1. Create Event.");
        System.out.println("2. List Events.");
        System.out.println("3. Create Venue.");
        System.out.println("4. List Venues.");
        System.out.println("5. Register Artist.");
        System.out.println("6. List Artists.");
        System.out.println("7. Create Ticket.");
        System.out.println("8. Sell Ticket.");
        System.out.println("9. Register Attendee.");
        System.out.println("10. Show Attendace Statistics.");
        System.out.println("0. Exit.");
        System.out.println("Select an option:");
    }
    
    private static void createEvent(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(EVENTS_FILE))){
            System.out.println("Enter Event ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Event Name: ");
            String name = scanner.nextLine();
            System.out.println("Enter Event Date (YYYY-MM-DD): ");
            String dateInput = scanner.nextLine();
            LocalDate date = LocalDate.parse(dateInput);
            System.out.println("Enter Event Time (HH:MM): ");
            String timeInput = scanner.nextLine();
            LocalTime time = LocalTime.parse(timeInput);
            System.out.println("Enter Event Location: ");
            String location = scanner.nextLine();
            System.out.println("Enter Event Category: ");
            String category = scanner.nextLine();

            writer.write(id + "," + name + "," + date + "," + time + "," + location + "," + category);
            writer.newLine();
            System.out.println("Event created succefully!");
        }catch (IOException e){
            System.err.println("Error writing event: " + e.getMessage());
        }
      }
    
    private static void createVenue(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(VENUES_FILE))){
            System.out.println("Enter Venue ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Venue Name: ");
            String name = scanner.nextLine();
            System.out.println("Enter Venue Capacity: ");
            int capacity = scanner.nextInt();
            scanner.nextLine();

            writer.write(id + "," +  name + "," + capacity);
            writer.newLine();
            System.out.println("Venue created successfully!");
        }catch (IOException e){
            System.out.println("Error writing event: " + e.getMessage());
        }
    }
    
    private static void registerArtist(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(ARTIST_FILE))){
            System.out.println("Enter Artist ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Artist Name: ");
            String name = scanner.nextLine();
            System.out.println("Enter Artist Contact Info: ");
            String contact = scanner.nextLine();

            writer.write(id + "," + name + "," + contact);
            writer.newLine();
            System.out.println("Artist registered successsfully!");
        }catch (IOException e){
            System.err.println("Error wrting artist " + e.getMessage());
        }
    }
    
    private static void createTicket(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TICKET_FILE))){
            System.out.println("Enter Ticket ID: ");
            int id = scanner.nextInt();
            System.out.println("Enter Event ID for Ticket: ");
            int eventId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Ticket Type (e.g. General, VIP): ");
            String type = scanner.nextLine();
            System.out.println("Enter Ticket Price: ");
            double price = scanner.nextDouble();

            writer.write(id + "," +  eventId + "," +  type + "," +  price + ",false");
            writer.newLine();
            System.out.println("Ticket created successfully!");
        }catch (IOException e){
            System.out.println("Error writing ticket " + e.getMessage());
            
        }
    }
    
    private static void sellTicket(){
        System.out.println("Enter Ticket ID to sell: ");
        int id = scanner.nextInt();
        File inputFile = new File(TICKET_FILE);
        File tempFile = new File("data/ticket_temp.txt");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))){
        
            String line;
            boolean  found =  false;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                if(parts.length == 5 && Integer.parseInt(parts[0]) == id){
                    if(parts[4].equals(true)){
                        System.out.println("Ticket already sold.");
                        writer.write(line);
                    }else{
                        writer.write(parts[0] + "," + parts[1] + "," + parts[2] + "," + parts[3] + ",true");
                        System.out.println("Ticket sold successfully!");
                    }
                    found = true;
                }else{
                    writer.write(line);
                }
                writer.newLine();
            }
            if(!found) System.out.println("Ticket not found.");
        }catch (IOException e){
            System.out.println("Error processing ticket sale: " + e.getMessage());
        }
        inputFile.delete();
        tempFile.renameTo(inputFile);
        
    }
    private static void registerAttendee(){
        System.out.println("Enter Attendee Name: ");
        String name = scanner.nextLine();
        accessControl.registerAttendee(name);
    }
    
    private static void listFromFile(String fileName){
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println("No data found or error reading file: " + fileName);
        }
    }
}

    
