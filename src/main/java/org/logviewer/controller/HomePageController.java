package org.logviewer.controller;

import com.jcraft.jsch.Session;
import common.config.LogConfig;
import org.logviewer.builder.HomePageResponseBuilder;
import org.logviewer.response.homepage.HomePageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by philip on 27/5/17.
 */
@Controller
public class HomePageController {

    @Autowired
    LogConfig config;

    @Autowired
    SessionStore sessionStore;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) throws Exception {
        HomePageResponseBuilder responseBuilder = new HomePageResponseBuilder();
        responseBuilder.setLogConfig(config);
        responseBuilder.setSessionStore(sessionStore);
        HomePageResponse configResponse = responseBuilder.buildHomepageResponse();
        model.put("config", configResponse);
        return "homepage";
    }
    @RequestMapping("/2")
    @ResponseBody
    public String welcome2() {
        return "asdf";
    }
}
