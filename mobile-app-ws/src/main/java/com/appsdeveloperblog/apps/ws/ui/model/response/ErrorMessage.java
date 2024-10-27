package com.appsdeveloperblog.apps.ws.ui.model.response;

import java.util.Date;

public class ErrorMessage {

    public ErrorMessage(String code, String message, Date timestamp) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }

    public ErrorMessage() {
    }


    private String code;
    private String message;
    private Date timestamp;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
