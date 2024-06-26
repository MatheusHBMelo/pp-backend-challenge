package tech.mhbm.pp_backend.domain.controllers.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransferRequest(@NotNull(message = "PayerId cannot be null") Long payerId,
                              @NotNull(message = "PayeeId cannot be null") Long payeeId,
                              @NotNull(message = "Value cannot be null") @DecimalMin(value = "0.01", message = "value cannot be less than $0.01") BigDecimal value) {

}
