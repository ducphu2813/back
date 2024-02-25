/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package back;

import DAL.CourseDAL;
import DAL.StudentGradeDAL;
import DTO.CourseDTO;
import DTO.StudentGrade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DUC PHU
 */
public class TestDAL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentGradeDAL DAL = new StudentGradeDAL();
        
        List<StudentGrade> list = new ArrayList<>();
        list = DAL.getAll();
        
        for(StudentGrade course : list)
        {
            System.out.println(""+course.toString());
        }
//        CourseDTO course = new CourseDTO();
//        course.setCourseID(1);
//        course.setTitle("MHPL");
//        course.setCredits(2);
//        course.setDepartmentID(7);
    }
    
}
