package tech.mhbm.pp_backend.domain.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.mhbm.pp_backend.domain.controllers.dtos.TransferRequest;
import tech.mhbm.pp_backend.domain.controllers.dtos.TransferResponse;
import tech.mhbm.pp_backend.domain.services.TranferService;

@RestController
@RequestMapping(path = "/transfer")
public class TranferController {
    private final TranferService tranferService;

    public TranferController(TranferService tranferService) {
        this.tranferService = tranferService;
    }

    @PostMapping
    public ResponseEntity<TransferResponse> createTransfer(@RequestBody TransferRequest transferRequest) {
        var result = tranferService.createTransfer(transferRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
