package br.com.coderbank.customerportal.repository;

import br.com.coderbank.customerportal.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String clientEmail);
}
