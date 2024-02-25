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
public class Department {
    private int departmentID, Administrator;
    private String name;
    private double budget;
    private LocalDate startDate;

    public Department(int departmentID, int Administrator, String name, double budget, LocalDate startDate) {
        this.departmentID = departmentID;
        this.Administrator = Administrator;
        this.name = name;
        this.budget = budget;
        this.startDate = startDate;
    }

    public Department() {
    }

    
    
    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getAdministrator() {
        return Administrator;
    }

    public void setAdministrator(int Administrator) {
        this.Administrator = Administrator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Department{" + "departmentID=" + departmentID + ", name=" + name + ", budget=" + budget + ", startDate=" + startDate + ", Administrator=" + Administrator + '}';
    }
    
    
}
