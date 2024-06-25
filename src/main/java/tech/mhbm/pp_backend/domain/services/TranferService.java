package tech.mhbm.pp_backend.domain.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tech.mhbm.pp_backend.domain.controllers.dtos.TransferRequest;
import tech.mhbm.pp_backend.domain.controllers.dtos.TransferResponse;
import tech.mhbm.pp_backend.domain.controllers.exceptions.InsufficientBalanceException;
import tech.mhbm.pp_backend.domain.controllers.exceptions.TransferNotAllowedForWalletTypeException;
import tech.mhbm.pp_backend.domain.controllers.exceptions.WalletNotFoundException;
import tech.mhbm.pp_backend.domain.models.Transfer;
import tech.mhbm.pp_backend.domain.models.Wallet;
import tech.mhbm.pp_backend.domain.repositories.TransferRepository;
import tech.mhbm.pp_backend.domain.repositories.WalletRepository;
import tech.mhbm.pp_backend.domain.services.exceptions.UnauthorizedTransactionException;

import java.util.concurrent.CompletableFuture;

@Service
public class TranferService {
    private final TransferRepository transferRepository;
    private final WalletRepository walletRepository;
    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;

    public TranferService(TransferRepository transferRepository,
                          WalletRepository walletRepository,
                          AuthorizationService authorizationService,
                          NotificationService notificationService) {
        this.transferRepository = transferRepository;
        this.walletRepository = walletRepository;
        this.authorizationService = authorizationService;
        this.notificationService = notificationService;
    }

    @Transactional
    public TransferResponse createTransfer(TransferRequest transferRequest) {
        var sender = walletRepository.findById(transferRequest.payerId())
                .orElseThrow(() -> new WalletNotFoundException("Not exists wallet with id: " + transferRequest.payerId()));
        var receiver = walletRepository.findById(transferRequest.payeeId())
                .orElseThrow(() -> new WalletNotFoundException("Not exists wallet with id: " + transferRequest.payeeId()));

        validateTransfer(transferRequest, sender);

        sender.debit(transferRequest.value());
        receiver.credit(transferRequest.value());

        var transfer = new Transfer(sender, receiver, transferRequest.value());

        walletRepository.save(sender);
        walletRepository.save(receiver);

        var transferResult = transferRepository.save(transfer);

        CompletableFuture.runAsync(() -> notificationService.sendNotification(transferResult));

        return transferResult.TransferResponse();
    }

    private void validateTransfer(TransferRequest transferRequest, Wallet sender) {
        if (!sender.walletTypeIsAllowed()) {
            throw new TransferNotAllowedForWalletTypeException("Merchant type users cannot send money");
        }

        if (!sender.balanceIsGreaterThanOrEqual(transferRequest.value())) {
            throw new InsufficientBalanceException("The Wallet balance is less than the amount you are trying to transfer.");
        }

        if (!authorizationService.authorize(transferRequest)) {
            throw new UnauthorizedTransactionException("The transfer was not authorized by the validation service");
        }
    }
}
