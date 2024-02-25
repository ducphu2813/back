/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.math.BigDecimal;

/**
 *
 * @author DUC PHU
 */
public class StudentGrade {
    private int enrollmentID, courseID, studentID;
    private BigDecimal grade;

    public StudentGrade(int enrollmentID, int courseID, int studentID, BigDecimal grade) {
        this.enrollmentID = enrollmentID;
        this.courseID = courseID;
        this.studentID = studentID;
        this.grade = grade;
    }

    public StudentGrade() {
    }

    @Override
    public String toString() {
        return "StudentGrade{" + "enrollmentID=" + enrollmentID + ", courseID=" + courseID + ", studentID=" + studentID + ", grade=" + grade + '}';
    }
    
    

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }
    
    
    
}
