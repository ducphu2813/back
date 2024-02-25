/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;


import DTO.Person;
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
public class PersonDAL {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public PersonDAL() {
        conn = MyConnection.getConnection();
    }
    
    public void add(Person person)
    {
        String sql = "insert into Person values(?, ?, ?, ?, ?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, person.getPersonID());
            pstmt.setString(2, person.getLastName());
            pstmt.setString(3, person.getFirstName());
            if(person.getRole().equals("student"))
            {
                Date sqlEnrollDate = Date.valueOf(person.getEnrollmentDate());
                pstmt.setDate(5, sqlEnrollDate);
                pstmt.setDate(4, null);
            }
            else{
                Date sqlHireDate = Date.valueOf(person.getHireDate());
                pstmt.setDate(4, sqlHireDate);
                pstmt.setDate(5, null);
            }
            pstmt.execute();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void update(Person person)
    {
        String sql = "update Person"
                    + " set Lastname = ?,"
                    + " Firstname = ?,"
                    + " HireDate = ?,"
                    + " EnrollmentDate = ? "
                    + " where PersonID = ? ";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, person.getLastName());
            pstmt.setString(2, person.getFirstName());
            if(person.getRole().equals("student"))
            {
                Date sqlEnrollDate = Date.valueOf(person.getEnrollmentDate());
                pstmt.setDate(4, sqlEnrollDate);
                pstmt.setDate(3, null);
            }
            else{
                Date sqlHireDate = Date.valueOf(person.getHireDate());
                pstmt.setDate(3, sqlHireDate);
                pstmt.setDate(4, null);
            }
            pstmt.setInt(5, person.getPersonID());
            pstmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void delete(int id)
    {
        String sql = "delete from Person where PersonID = ?";
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
        ArrayList personList = new ArrayList<Person>();
        
        String sql = "select * from Person";
        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                Person person = new Person();
                person.setPersonID(rs.getInt(1));
                person.setLastName(rs.getString(2));
                person.setFirstName(rs.getString(3));
                if(rs.getDate(4) == null)
                {
                    person.setRole("student");
                    person.setEnrollmentDate(rs.getDate(5).toLocalDate());
                }
                else{
                    person.setRole("instructor");
                    person.setHireDate(rs.getDate(4).toLocalDate());
                }
                personList.add(person);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return personList;
    }
}
