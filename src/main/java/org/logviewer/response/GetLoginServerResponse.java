package org.logviewer.response;

import java.util.List;

/**
 * Created by philip on 27/5/17.
 */
public class GetLoginServerResponse extends BaseResponse{
    private List<ToLoginServer> servers;

    public List<ToLoginServer> getServers() {
        return servers;
    }

    public void setServers(List<ToLoginServer> servers) {
        this.servers = servers;
    }
}
