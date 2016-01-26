package com.company.example.model;

/**
 * Created by michaeldecourci on 26/01/2016.
 */
public class Validations {
    public static <T> void require(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }
}
