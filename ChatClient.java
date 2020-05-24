package sca.net.pojo;

import java.util.Objects;

/**
 *
 * @author sneha
 */
public class ChatClient {
    
    String UserName;
    String Password;
    public ChatClient()
    {
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final ChatClient other = (ChatClient) obj;
        if (!Objects.equals(this.UserName, other.UserName)) {
            return false;
        }
        if (!Objects.equals(this.Password, other.Password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ChatClient{" + "UserName=" + UserName + ", Password=" + Password + '}';
    }

    public ChatClient(String UserName, String Password) {
        this.UserName = UserName;
        this.Password = Password;
    }
    

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
    
}

