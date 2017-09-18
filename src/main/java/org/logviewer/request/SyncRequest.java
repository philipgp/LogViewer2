/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.logviewer.request;

import common.config.LogServer;

import java.util.List;

/**
 * Created by philip on 27/5/17.
 */
public class SyncRequest extends BaseRequest {
    private String appName,environment;
    private List<LogServer> servers;
    private List<String> loggerNames;
    private String fromDate,toDate;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public List<LogServer> getServers() {
        return servers;
    }

    public void setServers(List<LogServer> servers) {
        this.servers = servers;
    }

    public List<String> getLoggerNames() {
        return loggerNames;
    }

    public void setLoggerNames(List<String> loggerNames) {
        this.loggerNames = loggerNames;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SyncRequest{");
        sb.append("appName='").append(appName).append('\'');
        sb.append(", environment='").append(environment).append('\'');
        sb.append(", servers=").append(servers);
        sb.append(", loggerNames=").append(loggerNames);
        sb.append(", fromDate='").append(fromDate).append('\'');
        sb.append(", toDate='").append(toDate).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
