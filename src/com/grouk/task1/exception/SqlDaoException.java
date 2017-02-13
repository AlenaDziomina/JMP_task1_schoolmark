package com.grouk.task1.exception;

/**
 * Created by Alena on 12.02.2017.
 */
public class SqlDaoException extends RuntimeException {
    public SqlDaoException() {
        super();
    }

    public SqlDaoException(String message) {
        super(message);
    }

    public SqlDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public SqlDaoException(Throwable cause) {
        super(cause);
    }

    protected SqlDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
