package tech.mhbm.pp_backend.domain.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import tech.mhbm.pp_backend.domain.clients.dtos.AuthorizationResponse;

@FeignClient(name = "AuthorizationClient", url = "${service.authorization-client.url}")
public interface AuthorizationClient {
    @GetMapping
    ResponseEntity<AuthorizationResponse> isAuthorized();
}
