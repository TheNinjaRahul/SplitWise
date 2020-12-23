package com.rahul.splitwise.model;

/**
 * The type Error model.
 */
public class ErrorModel {
    /**
     * The Status code.
     */
    int statusCode;
    /**
     * The Message.
     */
    String message;

    /**
     * Instantiates a new Error model.
     *
     * @param statusCode the status code
     * @param message    the message
     */
    public ErrorModel(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
