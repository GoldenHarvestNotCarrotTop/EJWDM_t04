package by.epamtc.task_1.exception;

public class NullStringException extends Exception{
    public NullStringException() {
        super();
    }

    public NullStringException(String message) {
        super(message);
    }

    public NullStringException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullStringException(Throwable cause) {
        super(cause);
    }

    protected NullStringException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
