package org.logviewer.controller;

import org.logviewer.request.GetLoginServerRequest;
import org.logviewer.request.LoginRequest;
import org.logviewer.response.GetLoginServerResponse;
import org.logviewer.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by philip on 27/5/17.
 */
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/getServersToLogin")
    @ResponseBody
    public GetLoginServerResponse getLoginServerResponse(GetLoginServerRequest request){
        return loginService.getServers(request);
    }

    @RequestMapping("/login")
    @ResponseBody
    public LoginResponse getLoginServerResponse(LoginRequest request){
        return loginService.doLogin(request);
    }
}
