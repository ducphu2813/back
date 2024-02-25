/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDate;

/**
 *
 * @author DUC PHU
 */
public class OfficeAssignment {
    private int instructorID;
    private String location;
    private LocalDate timestamp;

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public OfficeAssignment() {
    }

    @Override
    public String toString() {
        return "OfficeAssignment{" + "instructorID=" + instructorID + ", location=" + location + ", timestamp=" + timestamp + '}';
    }
    
    
}
