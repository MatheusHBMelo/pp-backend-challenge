package tech.mhbm.pp_backend.domain.controllers.exceptions;

public class TransferNotAllowedForWalletTypeException extends RuntimeException {
    public TransferNotAllowedForWalletTypeException(String message) {
        super(message);
    }
}
