package org.logviewer.response.homepage;

import common.config.LogServer;

/**
 * Created by philip on 3/6/17.
 */
public class ServerHomePage extends LogServer{
    private boolean loginRequired;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ServerHomePage{");
        sb.append("loginRequired=").append(loginRequired);
        sb.append('}');
        return sb.toString();
    }

    public boolean isLoginRequired() {
        return loginRequired;
    }

    public void setLoginRequired(boolean loginRequired) {
        this.loginRequired = loginRequired;
    }
}
