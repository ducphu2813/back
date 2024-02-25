/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.OfficeAssignment;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DUC PHU
 */
public class OfficeAssignmentDAL {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public OfficeAssignmentDAL() {
        conn = MyConnection.getConnection();
    }
    
    public void add(OfficeAssignment assign)
    {
        String sql = "insert into OfficeAssignment values(?, ?, ?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, assign.getInstructorID());
            pstmt.setString(2, assign.getLocation());
            Date sqlDate = Date.valueOf(assign.getTimestamp());
            pstmt.setDate(3, sqlDate);
            pstmt.execute();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void update(OfficeAssignment assign)
    {
        String sql = "update OfficeAssignment "
                    + " set Location = ?, "
                    + " set Timestamp = ? "
                    + " where InstructorID = ?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, assign.getLocation());
            Date sqlDate = Date.valueOf(assign.getTimestamp());
            pstmt.setDate(2, sqlDate);
            pstmt.setInt(3, assign.getInstructorID());
            pstmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void delete(int id)
    {
        String sql = "delete from OfficeAssignment where InstructorID = ?";
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
        ArrayList list = new ArrayList<OfficeAssignment>();
        
        String sql = "select * from OfficeAssignment";
        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                OfficeAssignment assign = new OfficeAssignment();
                assign.setInstructorID(rs.getInt(1));
                assign.setLocation(rs.getString(2));
                assign.setTimestamp(rs.getDate(3).toLocalDate());
                list.add(assign);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return list;
    }
    
    
}
