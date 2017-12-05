package br.edu.thejukebox.repository;


import br.edu.thejukebox.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findAccountByUsername(String username);
}