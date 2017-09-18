package org.logviewer.response;

import org.logviewer.vo.Status;

/**
 * Created by philip on 27/5/17.
 */
public class LoginResponse extends BaseResponse{
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LoginResponse{");
        sb.append("status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
