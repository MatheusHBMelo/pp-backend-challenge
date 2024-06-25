package tech.mhbm.pp_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PpBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PpBackendApplication.class, args);
	}

}
