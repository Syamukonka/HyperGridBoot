package com.major.hypergridboot.exception;

public class InvalidCustomerDetailsException extends Exception{

    public InvalidCustomerDetailsException() {
        super();
    }

    public InvalidCustomerDetailsException(String message) {
        super(message);
    }

    public InvalidCustomerDetailsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCustomerDetailsException(Throwable cause) {
        super(cause);
    }

    protected InvalidCustomerDetailsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
