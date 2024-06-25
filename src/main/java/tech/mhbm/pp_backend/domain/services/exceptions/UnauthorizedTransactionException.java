package tech.mhbm.pp_backend.domain.services.exceptions;

public class UnauthorizedTransactionException extends RuntimeException{
    public UnauthorizedTransactionException(String message) {
        super(message);
    }
}
