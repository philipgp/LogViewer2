package org.logviewer.builder;

import common.config.LogConfig;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by philip on 3/6/17.
 */
public class HomePageResponseBuilderTest {
    @Test
    public void buildHomepageResponse() throws Exception {
        HomePageResponseBuilder homePageResponseBuilder = new HomePageResponseBuilder();
        LogConfig logConfig = new LogConfig();
        homePageResponseBuilder.setLogConfig(logConfig);

    }

}
