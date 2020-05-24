/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sca.net.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
 public class DBConnection {

      private static Connection conn;
    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");

            conn=DriverManager.getConnection("jdbc:oracle:thin:@//MyLaptop:1521/xe","adv","abcd");
JOptionPane.showMessageDialog(null,"connected successfully to database","success!",JOptionPane.INFORMATION_MESSAGE);           
            
        }
catch(ClassNotFoundException ex)
{
JOptionPane.showMessageDialog(null,"error loading driver"+ex,"error",JOptionPane.ERROR_MESSAGE);
ex.printStackTrace();
}
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQL error"+ex,"error!",JOptionPane.ERROR_MESSAGE);
ex.printStackTrace();
            
            
        }
    }
    public static Connection getConnection()
    {
        return conn;
        }     
 public static void closeConnection()
 {
    try
    {
        conn.close();
    }
    catch(SQLException sq)
    {
     JOptionPane.showMessageDialog(null,"SQL error"+sq,"error!",JOptionPane.ERROR_MESSAGE);
sq.printStackTrace();
               
        
    }
    
 }
 
 
 }
   