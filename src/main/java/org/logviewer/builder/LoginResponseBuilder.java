package org.logviewer.builder;

import org.logviewer.response.LoginResponse;
import org.logviewer.vo.Status;

/**
 * Created by philip on 3/6/17.
 */
public class LoginResponseBuilder {
    private Status loginStatus;

    public LoginResponse buildLoginResponse(){
        LoginResponse response = new LoginResponse();
        response.setStatus(loginStatus);

        return response;
    }

    public void setLoginStatus(Status loginStatus) {
        this.loginStatus = loginStatus;
    }
}
