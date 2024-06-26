package tech.mhbm.pp_backend.domain.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tech.mhbm.pp_backend.domain.models.Wallet;
import tech.mhbm.pp_backend.domain.models.WalletType;

public record WalletRequestDto(@NotBlank(message = "Name cannot be blank") String name,
                               @NotBlank(message = "CpfCnpj cannot be blank") String cpfCnpj,
                               @NotBlank(message = "Email cannot be blank") String email,
                               @NotBlank(message = "Password cannot be blank") String password,
                               @NotNull(message = "WalletType cannot be null") WalletType.Enum walletType) {
    public Wallet toWallet() {
        return new Wallet(name, cpfCnpj, email, password, walletType.get());
    }
}
