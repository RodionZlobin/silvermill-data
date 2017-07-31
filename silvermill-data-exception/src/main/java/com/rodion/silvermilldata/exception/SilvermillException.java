package com.rodion.silvermilldata.exception;

/**
 * @author Rodion
 */

public final class SilvermillException extends Exception
{
    private static final long serialVersionUID = 1L;

    public SilvermillException(String message)
    {
        super(message);
    }

    public SilvermillException(String message, Throwable cause)
    {
        super(message, cause);
    }
}