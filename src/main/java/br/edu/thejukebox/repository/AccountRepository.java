package br.edu.thejukebox.repository;


import br.edu.thejukebox.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    Account findAccountByUsername(String username);
}