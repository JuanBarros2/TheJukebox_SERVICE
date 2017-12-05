package br.edu.thejukebox.repository;


import br.edu.thejukebox.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findAccountByUsername(String username);
    boolean existsDistinctByEmail(String email);
}