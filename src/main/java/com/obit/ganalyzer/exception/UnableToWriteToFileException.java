package com.obit.ganalyzer.exception;

public class UnableToWriteToFileException extends RuntimeException{

    public UnableToWriteToFileException(String message, Throwable e) {
        super(message, e);
    }
}
