package tech.mhbm.pp_backend.domain.services;

import org.springframework.stereotype.Service;
import tech.mhbm.pp_backend.domain.controllers.dtos.WalletRequestDto;
import tech.mhbm.pp_backend.domain.controllers.dtos.WalletResponseDto;
import tech.mhbm.pp_backend.domain.repositories.WalletRepository;
import tech.mhbm.pp_backend.domain.services.exceptions.WalletAlreadyExistsException;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public WalletResponseDto createWallet(WalletRequestDto walletRequestDto) {
        var result = walletRepository.findByCpfCnpjOrEmail(walletRequestDto.cpfCnpj(), walletRequestDto.email());

        if (result.isPresent()) {
            throw new WalletAlreadyExistsException("Wallet already exists with this cpfCnpj or email");
        }

        return walletRepository.save(walletRequestDto.toWallet()).toWalletResponseDto();
    }
}
