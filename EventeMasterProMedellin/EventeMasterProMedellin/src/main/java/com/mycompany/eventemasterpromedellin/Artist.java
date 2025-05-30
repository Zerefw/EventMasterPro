package com.mycompany.eventemasterpromedellin;

import java.io.*;

public class Artist {
    private final int id;
    private final String name;
    private final String contactInfo;
    private final String technicalRequirements;
    private final String participationHistory;

    private static final String FILE_NAME = "artists.txt";

    public Artist(int id, String name, String contactInfo, String technicalRequirements, String participationHistory) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.technicalRequirements = technicalRequirements;
        this.participationHistory = participationHistory;
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(id + "," + name + "," + contactInfo + "," + technicalRequirements + "," + participationHistory);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to artist file: " + e.getMessage());
        }
    }

    public static void listArtistsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No artists found.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length >= 5) {
                    System.out.println("Artist ID: " + parts[0] + ", Name: " + parts[1] + ", Contact Info: " + parts[2]);

                    System.out.println("  Technical Requirements:");
                    for (String req : parts[3].split(";")) {
                        if (!req.isBlank()) System.out.println("    - " + req);
                    }

                    System.out.println("  Participation History:");
                    for (String event : parts[4].split(";")) {
                        if (!event.isBlank()) System.out.println("    - " + event);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from artist file: " + e.getMessage());
        }
    }
}
