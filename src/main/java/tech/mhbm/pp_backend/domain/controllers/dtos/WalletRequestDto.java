package tech.mhbm.pp_backend.domain.controllers.dtos;

import tech.mhbm.pp_backend.domain.models.Wallet;
import tech.mhbm.pp_backend.domain.models.WalletType;

public record WalletRequestDto(String name,
                               String cpfCnpj,
                               String email,
                               String password,
                               WalletType.Enum walletType) {
    public Wallet toWallet() {
        return new Wallet(name, cpfCnpj, email, password, walletType.get());
    }
}
