package tech.mhbm.pp_backend.domain.controllers.dtos;

import java.math.BigDecimal;

public record TransferRequest(Long payerId, Long payeeId, BigDecimal value) {

}
