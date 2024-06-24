package tech.mhbm.pp_backend.domain.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.mhbm.pp_backend.domain.models.exceptions.InvalidEnumValueException;
import tech.mhbm.pp_backend.domain.services.exceptions.WalletAlreadyExistsException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(WalletAlreadyExistsException.class)
    public ResponseEntity<ProblemDetail> WalletAlreadyExistsExceptionHandler(WalletAlreadyExistsException e) {
        ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.UNAUTHORIZED);
        pb.setTitle("Wallet already exists");
        pb.setDetail(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(pb);
    }

    @ExceptionHandler(InvalidEnumValueException.class)
    public ResponseEntity<ProblemDetail> InvalidEnumValueExceptionHandler(InvalidEnumValueException e) {
        ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("Invalid enum value");
        pb.setDetail(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pb);
    }
}
