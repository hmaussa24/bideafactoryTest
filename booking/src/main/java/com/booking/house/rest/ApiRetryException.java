package com.booking.house.rest;

public class ApiRetryException extends RuntimeException {
    public ApiRetryException(String message) {
        super(message);
    }
}
