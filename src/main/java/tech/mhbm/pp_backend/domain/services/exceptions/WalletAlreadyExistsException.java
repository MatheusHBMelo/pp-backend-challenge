package tech.mhbm.pp_backend.domain.services.exceptions;

public class WalletAlreadyExistsException extends RuntimeException {
    public WalletAlreadyExistsException(String message) {
        super(message);
    }
}
