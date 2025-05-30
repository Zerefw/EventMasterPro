package com.mycompany.eventemasterpromedellin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Venue {
    private int id;
    private String name;
    private int capacity;
    private String technicalFeatures; 
    private String availableDates;    

    private static final String FILE_NAME = "venues.txt";

    public Venue(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.technicalFeatures = "";
        this.availableDates = "";
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public String getTechnicalFeatures() { return technicalFeatures; }
    public String getAvailableDates() { return availableDates; }

    public void addTechnicalFeature(String feature) {
        if (!technicalFeatures.isEmpty()) {
            technicalFeatures += ",";
        }
        technicalFeatures += feature;
    }

    public void addAvailableDate(String date) {
        if (!availableDates.isEmpty()) {
            availableDates += ",";
        }
        availableDates += date;
    }

    public boolean isAvailable(String date) {
        String[] dates = availableDates.split(",");
        for (String d : dates) {
            if (d.trim().equals(date.trim())) {
                return true;
            }
        }
        return false;
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(id + ";" + name + ";" + capacity + ";" + technicalFeatures + ";" + availableDates);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving venue: " + e.getMessage());
        }
    }

    public static void listVenuesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); 
            }
        } catch (IOException e) {
            System.out.println("Error reading venues: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Venue ID: " + id + ", Name: " + name + ", Capacity: " + capacity +
                ", Technical Features: [" + technicalFeatures + "], Available Dates: [" + availableDates + "]";
    }
}
