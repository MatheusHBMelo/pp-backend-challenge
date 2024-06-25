package tech.mhbm.pp_backend.domain.services;

import org.springframework.stereotype.Service;
import tech.mhbm.pp_backend.domain.clients.AuthorizationClient;
import tech.mhbm.pp_backend.domain.controllers.dtos.TransferRequest;
import tech.mhbm.pp_backend.domain.services.exceptions.UnauthorizedTransactionException;

@Service
public class AuthorizationService {
    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean authorize(TransferRequest transferRequest) {
        var response = authorizationClient.isAuthorized();
        if (response == null) {
            throw new UnauthorizedTransactionException("Authorization response is null");
        }

        var statusCode = response.getStatusCode();
        if (statusCode.isError()) {
            throw new UnauthorizedTransactionException("Could not authorize transaction");
        }

        var body = response.getBody();
        if (body == null) {
            throw new UnauthorizedTransactionException("Authorization response body is null");
        }

        return body.authorized();
    }
}
