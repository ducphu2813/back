/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;


/**
 *
 * @author DUC PHU
 */
public class DepartmentDAL {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    
    public DepartmentDAL()
    {
        conn = MyConnection.getConnection();
    }
    
    public void add(Department department)
    {
        String sql = "insert into Department values(?, ?, ?, ?, ?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, department.getDepartmentID());
            pstmt.setString(2, department.getName());
            pstmt.setDouble(3, department.getBudget());
            Date sqlDate = Date.valueOf(department.getStartDate());
            pstmt.setDate(4, sqlDate);
            pstmt.setInt(5, department.getAdministrator());
            pstmt.execute();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void update(Department department)
    {
        String sql = "update Department "
                    +" set Name = ?, "
                    +" Budget = ?, "
                    +" StartDate = ?, "
                    +" Administrator = ? "
                    +" where DepartmentID = ?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(5, department.getDepartmentID());
            pstmt.setString(1, department.getName());
            pstmt.setDouble(2, department.getBudget());
            Date sqlDate = Date.valueOf(department.getStartDate());
            pstmt.setDate(3, sqlDate);
            pstmt.setInt(4, department.getAdministrator());
            pstmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void delete(int id)
    {
        String sql = "delete from Department where DepartmentID = ?";
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
        ArrayList DList = new ArrayList<Department>();
        
        String sql = "select * from Department";
        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                Department department = new Department();
                department.setDepartmentID(rs.getInt(1));
                department.setName(rs.getString(2));
                department.setBudget(rs.getDouble(3));
                department.setStartDate(rs.getDate(4).toLocalDate());
                department.setAdministrator(rs.getInt(5));
                DList.add(department);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return DList;
    }
}
