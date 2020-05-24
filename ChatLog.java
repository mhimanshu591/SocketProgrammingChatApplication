package sca.net.pojo;

import java.util.Objects;

/**
 *
 * @author sneha
 */
public class ChatLog {
    String username;
    String message;
    String msgTime;

    public ChatLog(String username, String message, String msgTime) {
        this.username = username;
        this.message = message;
        this.msgTime = msgTime;
    }
    public ChatLog()
    {
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChatLog other = (ChatLog) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.msgTime, other.msgTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ChatLog{" + "username=" + username + ", message=" + message + ", msgTime=" + msgTime + '}';
    }
    
    
    
    
}

