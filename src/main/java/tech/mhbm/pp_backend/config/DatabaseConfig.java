package tech.mhbm.pp_backend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import tech.mhbm.pp_backend.domain.models.WalletType;
import tech.mhbm.pp_backend.domain.repositories.WalletTypeRepository;

import java.util.Arrays;

@Configuration
public class DatabaseConfig implements CommandLineRunner {
    private final WalletTypeRepository walletTypeRepository;

    public DatabaseConfig(WalletTypeRepository walletTypeRepository) {
        this.walletTypeRepository = walletTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(WalletType.Enum.values()).forEach(walletType -> walletTypeRepository.save(walletType.get()));
    }
}
