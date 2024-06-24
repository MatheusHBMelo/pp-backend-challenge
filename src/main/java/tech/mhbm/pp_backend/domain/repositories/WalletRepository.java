package tech.mhbm.pp_backend.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.mhbm.pp_backend.domain.models.Wallet;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByCpfCnpjOrEmail(String cpfCnpj, String email);
}
