package tech.mhbm.pp_backend.domain.controllers.dtos;

import java.math.BigDecimal;

public record WalletResponseDto(String name,
                                String cpfCnpj,
                                String email,
                                String password,
                                String walletType,
                                BigDecimal balance) {
}
