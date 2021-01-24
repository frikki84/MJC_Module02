package com.epam.esm.exception;

import javax.validation.ValidationException;

public class InvalidDataException extends ValidationException {
    private String code;

    public InvalidDataException(String message, CustomErrorCode code) {
        super(message);
        this.code = code.getCode();
    }

    public String getCode() {
        return code;
    }
}
