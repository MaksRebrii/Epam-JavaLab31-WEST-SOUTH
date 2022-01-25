package com.epam.spring.homework2.beans.validator;

public class FieldsValidator {

    private FieldsValidator() {
    }

    public static void validate(String className, String name, int value) {
        if (name != null && value > 0) {
            System.out.println(className + " is valid");
        } else if (name == null) {
            System.out.println(className + " is not valid: name is null");
        } else {
            System.out.println(className + " is not valid: value <= 0");
        }
    }
}
