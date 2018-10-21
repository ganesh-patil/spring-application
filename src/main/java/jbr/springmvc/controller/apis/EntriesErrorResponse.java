package jbr.springmvc.controller.apis;

import java.sql.Timestamp;

public class EntriesErrorResponse {
    public int status;
    public String message;
    public Long timeStampt;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStampt() {
        return timeStampt;
    }

    public void setTimeStampt(Long timeStampt) {
        this.timeStampt = timeStampt;
    }
}
