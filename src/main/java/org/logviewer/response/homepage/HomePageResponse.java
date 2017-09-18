package org.logviewer.response.homepage;

import common.config.LogApplicationConfig;

import java.util.List;

/**
 * Created by philip on 3/6/17.
 */
public class HomePageResponse {
    List<LogApplicationConfig> applications;

    public List<LogApplicationConfig> getApplications() {
        return applications;
    }

    public void setApplications(List<LogApplicationConfig> applications) {
        this.applications = applications;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HomePageResponse{");
        sb.append("applications=").append(applications);
        sb.append('}');
        return sb.toString();
    }
}
