package ru.backend.supermarket.exception;

import java.util.Date;

public class OurError {
    private int status;
    private String message;
    private Date timestamp;

    public OurError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
