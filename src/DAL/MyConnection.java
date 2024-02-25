/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author DUC PHU
 */
public class MyConnection {
    
    private static Connection connection = null;
    static private String user = "learnspring";
    static private String password = "123456";
    static private String serverName = "localhost";
    static private String portNumber = "3306";
    static private String DBName = "school";
    
    public static Connection getConnection()
    {
        String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + DBName;
        
        if(connection == null)
        {
            try{
//                connection = ds.getConnection();
//                System.out.println("Ket noi thanh cong");
//                System.out.println(connection.getCatalog());
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connect successfully !");
                System.out.println("schema : "+connection.getCatalog());
            }
            catch (ClassNotFoundException | SQLException e) {
                System.out.println("Unable to connect to the database.");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
