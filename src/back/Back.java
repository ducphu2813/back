/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package back;
import DAL.DepartmentDAL;
import DAL.MyConnection;
import DAL.PersonDAL;
import DTO.Department;
import DTO.Person;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author DUC PHU
 */
public class Back {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.println("Hello");
//        Connection conn = MyConnection.getConnection();
//        if (conn != null) {
//            System.out.println("Connect success in main test !");
//            try {
//                conn.close();
//                System.out.println("Connection closed ");
//            } catch (SQLException e) {
//                System.out.println("Err when close connect: " + e.getMessage());
//            }
//        } else {
//            System.out.println("Unable to connect to database");
//        }
//        
//       

        //Test fetch data
//        DepartmentDAL deDAL = new DepartmentDAL();
//        ArrayList<Department> DList = new ArrayList<>();
//        DList = deDAL.getAll();
//        System.out.println("found : "+DList.size());
//        for(Department department : DList)
//        {
//            System.out.println(""+department.toString());
//        }

        //test save data
//        Department department = new Department();
//        department.setDepartmentID(5);
//        department.setName("CNTT");
//        department.setBudget(50000000);
//        LocalDate date = LocalDate.of(2020, 3, 18);
//        department.setStartDate(date);
//        department.setAdministrator(7);
//        deDAL.add(department);
//        
//        System.out.println("added department : "+department.toString());
//        
//        ArrayList<Department> DList = new ArrayList<>();
//        DList = deDAL.getAll();
//        System.out.println("found : "+DList.size());
//        for(Department dep : DList)
//        {
//            System.out.println(""+dep.toString());
//        }
        

        //test update
//        Department department = new Department();
//        department.setDepartmentID(5);
//        department.setName("Machine Learning");
//        department.setBudget(12345);
//        LocalDate date = LocalDate.of(2024, 3, 8);
//        department.setStartDate(date);
//        department.setAdministrator(7);
//        deDAL.update(department);
//        
//        ArrayList<Department> DList = new ArrayList<>();
//        DList = deDAL.getAll();
//        System.out.println("found : "+DList.size());
//        for(Department dep : DList)
//        {
//            System.out.println(""+dep.toString());
//        }

        //test delete
//        deDAL.delete(5);
        
        
        //test person
        PersonDAL personDAL = new PersonDAL();
        //add data
        Person person = new Person();
        person.setPersonID(50);
        person.setLastName("Manuel");
        person.setFirstName("Kanet");
        LocalDate enDate = LocalDate.of(2024, 3, 8);
        person.setEnrollmentDate(enDate);
        person.setRole("student");
//        personDAL.add(person);
        //update
        personDAL.update(person);
        //fetch data
        ArrayList<Person> list = new ArrayList<>();
        list = personDAL.getAll();
        for(Person per : list)
        {
            System.out.println(""+per.toString());
        }
    }
    
}
