package com.obit.ganalyzer.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CommonExitException extends RuntimeException {

    private static final int STATUS_FAILED = -1;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected CommonExitException(String message) {
        super(message);
        logger.error(message);
        System.exit(STATUS_FAILED);
    }
}
