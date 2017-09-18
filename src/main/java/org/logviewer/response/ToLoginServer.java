package org.logviewer.response;

/**
 * Created by philip on 27/5/17.
 */
public class ToLoginServer {

    private String name,hostName;
    private String userName,password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ToLoginServer() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ToLoginServer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", hostName='").append(hostName).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

}
