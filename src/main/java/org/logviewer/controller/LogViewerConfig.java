package org.logviewer.controller;

import common.config.LogConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by philip on 3/6/17.
 */
@Configuration
public class LogViewerConfig {
    @Bean
    public LogConfig logConfig() throws Exception {
        LogConfigReader loginConfigReader = new LogConfigReader();
        LogConfig config = loginConfigReader.getConfig();
        return config;
    }
}
