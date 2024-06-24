package tech.mhbm.pp_backend.domain.models.exceptions;

public class InvalidEnumValueException extends RuntimeException {
    public InvalidEnumValueException(String message) {
        super(message);
    }
}
