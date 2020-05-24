package sca.net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sca.net.dbutil.DBConnection;
import sca.net.pojo.ChatClient;

/**
 *
 * @author sneha
 */
public class ChatClientDao {
    public static boolean findClient(String username) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="select * from chatClients where username=?";
         PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,username);
        ResultSet rs=ps.executeQuery();
        return rs.next();
        
    }
     public static boolean addClient(ChatClient chatclient) throws SQLException
     {
         Connection conn=DBConnection.getConnection();
         boolean status=false;
         PreparedStatement ps=conn.prepareStatement("insert into ChatClients values(?,?)");
         ps.setString(1,chatclient.getUserName());
         ps.setString(2,chatclient.getPassword());
         int ans=ps.executeUpdate();
         if(ans!=0)
             status=true;
         return status;
         
         
     }
            
}

