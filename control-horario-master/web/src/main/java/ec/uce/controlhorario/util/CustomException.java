package ec.uce.controlhorario.util;

/**
 * @author dacopanCM on 23/03/16.
 */
public class CustomException extends RuntimeException {
    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}