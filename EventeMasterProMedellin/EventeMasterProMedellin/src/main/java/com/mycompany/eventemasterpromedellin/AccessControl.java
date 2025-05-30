package com.mycompany.eventemasterpromedellin;

import java.io.*;

public class AccessControl {
    private static final String FILE_NAME = "data/attendees.txt";

    public AccessControl() {
        File file = new File(FILE_NAME);
        try {
            file.getParentFile().mkdirs(); 
            file.createNewFile(); 
        } catch (IOException e) {
        }
    }

    public void registerAttendee(String attendeeName) {
        if (isAlreadyRegistered(attendeeName)) {
            System.out.println(attendeeName + " is already registered.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(attendeeName);
            writer.newLine();
            System.out.println(attendeeName + " has been successfully registered.");
        } catch (IOException e) {
        }
    }

    public void validateTicket(String attendeeName) {
        if (isAlreadyRegistered(attendeeName)) {
            System.out.println(attendeeName + " is allowed to enter.");
        } else {
            System.out.println(attendeeName + " is not registered for this event.");
        }
    }

    public void generateAttendanceStats() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            while (reader.readLine() != null) {
                count++;
            }
            System.out.println("Total registered attendees: " + count);
        } catch (IOException e) {
        }
    }

    private boolean isAlreadyRegistered(String attendeeName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase(attendeeName)) {
                    return true;
                }
            }
        } catch (IOException e) {
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Registered Attendees:\n");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
        }
        return sb.toString();
    }
}
