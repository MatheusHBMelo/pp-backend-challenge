package tech.mhbm.pp_backend.domain.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.mhbm.pp_backend.domain.controllers.dtos.WalletRequestDto;
import tech.mhbm.pp_backend.domain.controllers.dtos.WalletResponseDto;
import tech.mhbm.pp_backend.domain.services.WalletService;

@RestController
@RequestMapping(path = "/wallets")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public ResponseEntity<WalletResponseDto> createWallet(@RequestBody @Valid WalletRequestDto walletRequestDto) {
        var result = walletService.createWallet(walletRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
