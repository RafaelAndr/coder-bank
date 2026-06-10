package br.com.coderbank.customerportal.repository;

import br.com.coderbank.customerportal.entity.PendingAccount;
import br.com.coderbank.customerportal.enuns.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PendingAccountRepository extends JpaRepository<PendingAccount, UUID> {

    List<PendingAccount> findByAccountStatus(AccountStatus accountStatus);

    boolean existsByCustomerId(UUID id);

    PendingAccount findByCustomerId(UUID id);
}
