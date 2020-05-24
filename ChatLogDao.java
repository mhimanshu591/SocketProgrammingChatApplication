package sca.net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sca.net.dbutil.DBConnection;
import sca.net.pojo.ChatLog;

/**
 *
 * @author sneha
 */
public class ChatLogDao {
    
    public static boolean addChatLog(ChatLog chatlog)throws SQLException
    {boolean status=false;
      Connection conn=DBConnection.getConnection();
      PreparedStatement ps=conn.prepareStatement("insert into ChatLogs values(?,?,?)");
      ps.setString(1, chatlog.getMessage());
      ps.setString(2,chatlog.getMsgTime());
      ps.setString(3,chatlog.getUsername());
      int ans=ps.executeUpdate();
      if(ans!=0)
       status =true;
      return status;
    }
    
    
    
    
    
}

