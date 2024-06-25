package tech.mhbm.pp_backend.domain.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.mhbm.pp_backend.domain.models.Transfer;

@FeignClient(name = "NotificationClient", url = "${service.notification-client.url}")
public interface NotificationClient {
    @PostMapping
    ResponseEntity<Void> sendNotification(@RequestBody Transfer transfer);
}
