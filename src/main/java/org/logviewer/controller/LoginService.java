package org.logviewer.controller;

import org.logviewer.builder.LoginResponseBuilder;
import org.logviewer.request.GetLoginServerRequest;
import org.logviewer.request.LoginRequest;
import org.logviewer.response.GetLoginServerResponse;
import org.logviewer.response.LoginResponse;
import org.logviewer.response.ToLoginServer;
import org.logviewer.vo.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by philip on 27/5/17.
 */
@Component
public class LoginService extends BaseService{

    @Autowired
    SessionStore sessionStore;

    public LoginResponse doLogin(LoginRequest request) {
        ToLoginServer login = new ToLoginServer();
        login.setPassword(request.getPassword());
        login.setUserName(request.getUserName());
        login.setHostName(request.getHostname());
        login.setName(request.getName());
        Status status = sessionStore.login(login);
        LoginResponseBuilder responseBuilder = new LoginResponseBuilder();
        responseBuilder.setLoginStatus(status);
        return responseBuilder.buildLoginResponse();

    }
    public GetLoginServerResponse getServers(GetLoginServerRequest request) {
        return null;
    }
}
