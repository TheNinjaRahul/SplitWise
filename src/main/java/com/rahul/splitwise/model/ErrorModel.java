package com.rahul.splitwise.model;

public class ErrorModel {
    int statusCode;
    String message;

    public ErrorModel(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
