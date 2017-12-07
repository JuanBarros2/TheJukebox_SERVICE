package br.edu.thejukebox.repository;


import br.edu.thejukebox.model.Account;
import br.edu.thejukebox.model.Artist;
import br.edu.thejukebox.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findAccountByUser_Email(String email);
}