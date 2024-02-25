/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.StudentGrade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author DUC PHU
 */
public class StudentGradeDAL {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public StudentGradeDAL() {
        conn = MyConnection.getConnection();
    }
    
    public void add(StudentGrade grade)
    {
        String sql = "insert into StudentGrade values(?, ?, ?, ?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, grade.getEnrollmentID());
            pstmt.setInt(2, grade.getCourseID());
            pstmt.setInt(3, grade.getStudentID());
            pstmt.setBigDecimal(4, grade.getGrade());
            pstmt.execute();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void update(StudentGrade grade)
    {
        String sql = "update StudentGrade"
                    + " set Grade = ?"
                    + " where EnrollmentID = ?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setBigDecimal(1, grade.getGrade());
            pstmt.setInt(2, grade.getEnrollmentID());
            pstmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void delete(int id)
    {
        String sql = "delete from StudentGrade where EnrollmentID = ?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.execute();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public ArrayList getAll()
    {
        ArrayList list = new ArrayList<StudentGrade>();
        
        String sql = "select * from StudentGrade";
        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                StudentGrade grade = new StudentGrade();
                grade.setEnrollmentID(rs.getInt(1));
                grade.setCourseID(rs.getInt(2));
                grade.setStudentID(rs.getInt(3));
                grade.setGrade(rs.getBigDecimal(4));
                list.add(grade);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return list;
    }
}
