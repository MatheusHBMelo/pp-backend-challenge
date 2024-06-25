package tech.mhbm.pp_backend.domain.controllers.dtos;

import tech.mhbm.pp_backend.domain.models.Wallet;

import java.math.BigDecimal;
import java.util.UUID;

public record TransferResponse(UUID id, Wallet payerId, Wallet payeeId, BigDecimal value) {
}
